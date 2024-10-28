package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.ChangeProductStateDTO;
import net.wanho.dto.ProductDTO;
import net.wanho.po.Product;
import net.wanho.service.ProductService;
import net.wanho.mapper.ProductMapper;
import net.wanho.vo.ListVo;
import net.wanho.vo.ProductVO;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【product(商品表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

    @Override
    public ListVo<ProductVO> getProductPageList(Integer pageSize, Integer pageNum, ProductDTO productDTO) {
        Page<ProductVO> page1 = new Page<>(pageNum,pageSize);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq(!ObjectUtil.isEmpty(productDTO.getStoreId()),"sort_id",productDTO.getStoreId());
        wrapper.eq(!ObjectUtil.isEmpty(productDTO.getProductName()),"product_name",productDTO.getStoreId());
        wrapper.like(!ObjectUtil.isEmpty(productDTO.getBrandName()),"brand_name",productDTO.getBrandName());
        wrapper.like(!ObjectUtil.isEmpty(productDTO.getSupplyName()),"supply_name",productDTO.getSupplyName());
        wrapper.like(!ObjectUtil.isEmpty(productDTO.getPlaceName()),"place_name",productDTO.getPlaceName());
        wrapper.eq(!ObjectUtil.isEmpty(productDTO.getUpDownState()),"up_down_state",productDTO.getUpDownState());
        Page<ProductVO> page=this.baseMapper.getProductPageList(page1,wrapper);
        ListVo<ProductVO> productListVo = new ListVo<>(page.getCurrent(),page.getPages(),page.getTotal(),page.getSize(),page.maxLimit(),page.getRecords());
        return productListVo;
    }

    @Override
    public boolean addProduct(Product product) {
        return this.baseMapper.insert(product)>0;
    }

    @Override
    public ProductVO getProductById(String id) {
        return this.baseMapper.getProductById(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return this.baseMapper.updateById(product)>0;
    }

    @Override
    public boolean deleteProductById(String id) {
        return this.baseMapper.deleteById(id)>0;
    }

    @Override
    public boolean deleteBatch(String[] ids) {
        return this.deleteBatch(ids);
    }

    @Override
    public boolean changeState(ChangeProductStateDTO changeProductStateDTO) {
        Product product = this.baseMapper.selectById(changeProductStateDTO.getProductId());
        product.setUpDownState(changeProductStateDTO.getUpDownState());
        return this.baseMapper.updateById(product)>0;
    }
}




