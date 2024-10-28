package net.wanho.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.po.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 32093
* @description 针对表【product(商品表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:49
* @Entity net.wanho.po.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    Page<ProductVO> getProductPageList(Page<ProductVO> page,@Param("ew") QueryWrapper<Product> wrapper);

    ProductVO getProductById(String id);
}




