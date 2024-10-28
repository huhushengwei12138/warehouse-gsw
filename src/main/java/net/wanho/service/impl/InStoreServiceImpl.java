package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.InStoreDTO;
import net.wanho.mapper.ProductMapper;
import net.wanho.po.InStore;
import net.wanho.po.Product;
import net.wanho.service.InStoreService;
import net.wanho.mapper.InStoreMapper;
import net.wanho.vo.InStoreVO;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【in_store(入库单表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
public class InStoreServiceImpl extends ServiceImpl<InStoreMapper, InStore>
    implements InStoreService{
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ListVo<InStoreVO> getInstorePageList(Integer pageNum, Integer pageSize, InStoreDTO inStoreDTO) {
        Page<InStoreVO> inStorePage = new Page<>(pageNum,pageSize);
        QueryWrapper<InStoreVO> wrapper = new QueryWrapper<>();
        wrapper.eq(!ObjectUtil.isEmpty(inStoreDTO.getStoreId()),"i.store_id",inStoreDTO.getStoreId());
        wrapper.like(!ObjectUtil.isEmpty(inStoreDTO.getProductName()),"p.product_name",inStoreDTO.getProductName());
        Page<InStoreVO> page=this.baseMapper.getInstorePageList(inStorePage,wrapper);
        ListVo<InStoreVO> inStoreVOList=new ListVo<>(page.getCurrent(),page.getPages(),page.getTotal(),page.getSize(),page.maxLimit(),page.getRecords());
        return inStoreVOList;
    }

    @Override
    public boolean confirmInstore(InStore inStore) {
        inStore.setIsIn("1");
        Product product = productMapper.selectById(inStore.getProductId());
        product.setProductInvent(product.getProductInvent()+inStore.getInNum());
        return this.baseMapper.updateById(inStore)>0&&productMapper.updateById(product)>0;
    }
}




