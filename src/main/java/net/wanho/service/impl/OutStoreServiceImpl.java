package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.OutStoreDTO;
import net.wanho.mapper.ProductMapper;
import net.wanho.po.OutStore;
import net.wanho.po.Product;
import net.wanho.service.OutStoreService;
import net.wanho.mapper.OutStoreMapper;
import net.wanho.service.ProductService;
import net.wanho.vo.ListVo;
import net.wanho.vo.OutStoreVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 32093
* @description 针对表【out_store(出库单表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
@Transactional
public class OutStoreServiceImpl extends ServiceImpl<OutStoreMapper, OutStore>
    implements OutStoreService{
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ListVo<OutStoreVo> getOutStorePageList(Integer pageNum, Integer pageSize, OutStoreDTO outStoreDTO) {
        Page<OutStoreVo> page = new Page<>(pageNum,pageSize);
        QueryWrapper<OutStoreVo> wrapper = new QueryWrapper<>();
        wrapper.eq(!ObjectUtil.isEmpty(outStoreDTO.getStoreId()),"os.store_id",outStoreDTO.getStoreId());
        wrapper.like(!ObjectUtil.isEmpty(outStoreDTO.getProductName()),"p.product_name",outStoreDTO.getProductName());
        page=this.baseMapper.getOutStorePageList(page,wrapper);
        ListVo<OutStoreVo> outStoreVoList =new ListVo(page.getCurrent(), page.getSize(), page.getTotal(), page.getCurrent(), page.getPages(), page.getRecords());

        return outStoreVoList;
    }

    @Override
    public boolean confirmOutStore(OutStoreVo outStoreVo) {
        outStoreVo.setIsOut("1");
        Product product = productMapper.selectById(outStoreVo.getProductId());
        product.setProductInvent(product.getProductInvent()-outStoreVo.getOutNum());
        OutStore outStore = new OutStore();
        BeanUtils.copyProperties(outStoreVo,outStore);

        return this.baseMapper.updateById(outStore)>0&&productMapper.updateById(product)>0;
    }
}




