package net.wanho.controller;

import net.wanho.vo.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @GetMapping("/store-invent")
    public AjaxResult getStoreInvent(){

       return AjaxResult.success();
    }
}
