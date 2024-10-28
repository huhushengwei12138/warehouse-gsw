package net.wanho.controller;

import net.wanho.po.ProductType;
import net.wanho.service.ProductService;
import net.wanho.service.ProductTypeService;
import net.wanho.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductTypeService productTypeService;
    @GetMapping("/product-category-tree")
    public AjaxResult getproductCateTree(){
        List<ProductType> productTypeList=productTypeService.getproductCateTree();

        return AjaxResult.success(productTypeList);
    }

    @GetMapping("/verify-type-code")
    public AjaxResult verifyTypeCode(String typeCode){
        ProductType productType=productTypeService.verifyTypeCode(typeCode);
        return AjaxResult.success(productType);
    }

    @PostMapping("/type-add")
    public AjaxResult addType(@RequestBody ProductType productType){
        return productTypeService.addType(productType)?AjaxResult.success("添加商品成功"):AjaxResult.fail("添加商品失败");
    }

    @GetMapping("/{id}")
    public AjaxResult queryProductTypeById(@PathVariable String id){
        ProductType productType=productTypeService.queryProductTypeById(id);
        return AjaxResult.success(productType);
    }

    @PutMapping("/type-update")
    public AjaxResult updateProductType(@RequestBody ProductType productType){
        return productTypeService.updateProductType(productType)?AjaxResult.success("修改商品信息成功"):AjaxResult.success("修改商品信息失败");

    }

    @DeleteMapping("/type-delete/{id}")
    public AjaxResult deleteProductType(@PathVariable Integer id){
        return productTypeService.deleteProductType(id)?AjaxResult.success("删除商品信息成功"):AjaxResult.fail("删除商品信息失败");
    }
}
