package net.wanho.service;

import net.wanho.po.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 32093
* @description 针对表【product_type(商品分类表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface ProductTypeService extends IService<ProductType> {

    List<ProductType> getproductCateTree();

    ProductType verifyTypeCode(String typeCode);

    boolean addType(ProductType productType);

    ProductType queryProductTypeById(String id);

    boolean updateProductType(ProductType productType);

    boolean deleteProductType(Integer id);
}
