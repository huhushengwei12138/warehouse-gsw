package net.wanho.controller;

import net.wanho.dto.ChangeProductStateDTO;
import net.wanho.dto.ProductDTO;
import net.wanho.po.Product;
import net.wanho.service.ProductService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import net.wanho.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product-page-list")
    public AjaxResult getProductPageList(@RequestParam(required = false,defaultValue = "1") Integer pageSize,
                                         @RequestParam(required = false,defaultValue = "5") Integer pageNum,
                                         ProductDTO productDTO){

        ListVo<ProductVO> productListVo=productService.getProductPageList(pageSize,pageNum,productDTO);
        return AjaxResult.success(productListVo);
    }

    @PostMapping("/product-add")
    public AjaxResult addProduct(@RequestBody Product product){


        return productService.addProduct(product)?AjaxResult.success("商品添加成功！"):AjaxResult.fail("商品添加失败！");
    }

    @GetMapping("/{id}")
    public AjaxResult getProductById(@PathVariable String id){
        ProductVO product=productService.getProductById(id);
        return AjaxResult.success(product);
    }

    @PutMapping("/product-update")
    public AjaxResult updateProduct(@RequestBody Product product){
        return productService.updateProduct(product)?AjaxResult.success("商品信息修改成功！"):AjaxResult.fail("商品信息修改失败！");
    }
    @DeleteMapping("/product-delete/{id}")
    public AjaxResult deleteProductById(@PathVariable String id){
        return productService.deleteProductById(id)?AjaxResult.success("商品信息删除成功！"):AjaxResult.fail("商品信息删除失败！");

    }

    @DeleteMapping("/product-list-delete")
    public AjaxResult deleteBatch(@RequestBody String[] ids){
        return productService.deleteBatch(ids)?AjaxResult.success("商品信息批量删除成功！"):AjaxResult.fail("商品信息批量删除失败！");

    }

    @GetMapping("/exportTable")

    public AjaxResult exportTable(@RequestParam(required = false,defaultValue = "1")Integer pageSize,
                                  @RequestParam(required = false,defaultValue = "5")Integer pageNum,
                                  ProductDTO productDTO){
        ListVo<ProductVO> productPageList = productService.getProductPageList(pageSize, pageNum, productDTO);
        return AjaxResult.success(productPageList);
    }

    @PutMapping("/state-change")
    public AjaxResult changeState(@RequestBody ChangeProductStateDTO changeProductStateDTO){
        return productService.changeState(changeProductStateDTO)?AjaxResult.success("商品状态修改成功！"):AjaxResult.fail("商品状态修改失败！");
    }


}
