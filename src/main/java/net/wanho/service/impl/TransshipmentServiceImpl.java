package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.AddTransshipmentDTO;
import net.wanho.dto.TransshipmentDTO;
import net.wanho.mapper.ProductMapper;
import net.wanho.po.Product;
import net.wanho.po.Transshipment;
import net.wanho.po.UserInfo;
import net.wanho.service.TransshipmentService;
import net.wanho.mapper.TransshipmentMapper;
import net.wanho.util.CurrentUserUtil;
import net.wanho.vo.ListVo;
import net.wanho.vo.OutStoreVo;
import net.wanho.vo.TransshipmentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 32093
* @description 针对表【transshipment(调货单表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
@Transactional
public class TransshipmentServiceImpl extends ServiceImpl<TransshipmentMapper, Transshipment>
    implements TransshipmentService{
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ListVo<TransshipmentVo> getTeansshipmentPageList(Integer pageNum, Integer pageSize, TransshipmentDTO transshipmentDTO) {
        Page<TransshipmentVo> page = new Page<>(pageNum,pageSize);
        QueryWrapper<TransshipmentDTO> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtil.isEmpty(transshipmentDTO.getCreateName()),"create_name",transshipmentDTO.getCreateName());
        wrapper.eq(!ObjectUtil.isEmpty(transshipmentDTO.getSourceStoreId()),"t.source_store_id",transshipmentDTO.getSourceStoreId());
        wrapper.eq(!ObjectUtil.isEmpty(transshipmentDTO.getTargetStoreId()),"t.target_store_id",transshipmentDTO.getTargetStoreId());
        wrapper.eq(!ObjectUtil.isEmpty(transshipmentDTO.getSourceProductName()),"source_product_name",transshipmentDTO.getSourceProductName());
        wrapper.eq(!ObjectUtil.isEmpty(transshipmentDTO.getTargetProductName()),"target_product_name",transshipmentDTO.getTargetProductName());

        page=this.baseMapper.getTeansshipmentPageList(page,wrapper);
        ListVo<TransshipmentVo> listVo = new ListVo(page.getCurrent(), page.getSize(), page.getTotal(), page.getCurrent(), page.getPages(), page.getRecords());
        return listVo;
    }

    @Override
    public boolean addTransshipment(AddTransshipmentDTO addTransshipmentDTO) {
        Transshipment transshipment = new Transshipment();
        transshipment.setTargetStoreId(Integer.parseInt(addTransshipmentDTO.getTargetStoreId()));
        transshipment.setSourceProductId(Integer.parseInt(addTransshipmentDTO.getSourceProductId()));
        transshipment.setSourceStoreId(Integer.parseInt(addTransshipmentDTO.getSourceStoreId()));
        transshipment.setTransNum(Integer.parseInt(addTransshipmentDTO.getTransNum()));
        transshipment.setCreateBy(CurrentUserUtil.getCurrentUser());
        transshipment.setAuditState("0");
        System.out.println(transshipment);

        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getStoreId,addTransshipmentDTO.getTargetStoreId());
        wrapper.eq(Product::getProductNum,addTransshipmentDTO.getTargetProductNum());
        Product sourceProduct = productMapper.selectById(addTransshipmentDTO.getSourceProductId());
        Product targetProduct = productMapper.selectOne(wrapper);
        if(ObjectUtil.isNull(targetProduct)){
            Product product = new Product();
            BeanUtils.copyProperties(sourceProduct,product);
            product.setProductId(null);
            product.setProductInvent(0);
            product.setStoreId(Integer.parseInt(addTransshipmentDTO.getTargetStoreId()));
            productMapper.insert(product);
            transshipment.setTargetProductId(product.getProductId());
        }else{
            transshipment.setTargetProductId(targetProduct.getProductId());
        }




        return this.baseMapper.insert(transshipment)>0;
    }

    @Override
    public boolean confirmTransshipment(Transshipment transshipment) {
        transshipment.setAuditState("1");
        Product sourceProduct = productMapper.selectById(transshipment.getSourceProductId());
        Product targetProduct = productMapper.selectById(transshipment.getTargetProductId());
        targetProduct.setProductInvent(targetProduct.getProductInvent()+transshipment.getTransNum());
        sourceProduct.setProductInvent(sourceProduct.getProductInvent()-transshipment.getTransNum());
        return this.baseMapper.updateById(transshipment)>0&&productMapper.updateById(sourceProduct)>0&&productMapper.updateById(targetProduct)>0;
    }


}




