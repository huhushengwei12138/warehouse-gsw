package net.wanho.service;

import net.wanho.dto.ChangeProductStateDTO;
import net.wanho.dto.ProductDTO;
import net.wanho.po.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.ListVo;
import net.wanho.vo.ProductVO;

/**
* @author 32093
* @description 针对表【product(商品表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface ProductService extends IService<Product> {

    ListVo<ProductVO> getProductPageList(Integer pageSize, Integer pageNum, ProductDTO productDTO);

    boolean addProduct(Product product);

    ProductVO getProductById(String id);

    boolean updateProduct(Product product);

    boolean deleteProductById(String id);

    boolean deleteBatch(String[] ids);

    boolean changeState(ChangeProductStateDTO changeProductStateDTO);
}
