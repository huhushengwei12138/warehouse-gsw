package net.wanho.controller;

import net.wanho.dto.SupplyInfoDTO;
import net.wanho.po.Supply;
import net.wanho.service.SupplyService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supply")
public class SupplyController {
    @Autowired
    private SupplyService supplyService;
    @GetMapping("/supply-list")

    public AjaxResult getSupplyList(){
        List<Supply> supplyList=supplyService.getSupplyList();
        return AjaxResult.success(supplyList);
    }

    @GetMapping("/supply-page-list")
    public AjaxResult getSupplyPageList(@RequestParam(required = false,defaultValue = "1")int pageNum,
                                        @RequestParam(required = false,defaultValue = "5")int pageSize,
                                        SupplyInfoDTO supplyInfoDTO){
        ListVo<Supply> supplyListVo= supplyService.getSupplyPageList(pageNum,pageSize,supplyInfoDTO);
        return AjaxResult.success(supplyListVo);
    }
}
