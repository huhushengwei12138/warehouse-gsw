package net.wanho.controller;

import net.wanho.dto.AddTransshipmentDTO;
import net.wanho.dto.TransshipmentDTO;
import net.wanho.po.Transshipment;
import net.wanho.service.TransshipmentService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import net.wanho.vo.OutStoreVo;
import net.wanho.vo.TransshipmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transshipment")
public class TransshipmentController {
    @Autowired
    private TransshipmentService transshipmentService;
    @GetMapping("/transshipment-page-list")
    public AjaxResult getTeansshipmentPageList(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                               @RequestParam(required = false,defaultValue = "5")Integer pageSize,
                                               TransshipmentDTO transshipmentDTO){
        ListVo<TransshipmentVo> outStoreVoList=transshipmentService.getTeansshipmentPageList(pageNum,pageSize,transshipmentDTO);
        return AjaxResult.success(outStoreVoList);
    }

    @PostMapping("/transshipment-add")

    public AjaxResult addTransshipment(@RequestBody AddTransshipmentDTO addTransshipmentDTO ){

        return transshipmentService.addTransshipment(addTransshipmentDTO)?AjaxResult.success("添加调货单成功"):AjaxResult.fail("添加调货单失败");

    }

    @PutMapping("/transshipment-confirm")

    public AjaxResult confirmTransshipment(@RequestBody Transshipment transshipment){
        return transshipmentService.confirmTransshipment(transshipment)?AjaxResult.success("确认调货单成功"):AjaxResult.fail("确认调货单失败");
    }
}
