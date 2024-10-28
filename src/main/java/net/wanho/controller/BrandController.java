package net.wanho.controller;

import net.wanho.po.Brand;
import net.wanho.service.BrandService;
import net.wanho.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/brand-list")
    public AjaxResult getBrandList(){
        List<Brand> brandList=brandService.getBrandList();
        return AjaxResult.success(brandList);
    }
}
