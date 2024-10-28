package net.wanho.controller;

import net.wanho.dto.OutStoreDTO;
import net.wanho.service.OutStoreService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import net.wanho.vo.OutStoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outstore")
public class OutStoreController {
    @Autowired
    private OutStoreService outStoreService;
    @GetMapping("/outstore-page-list")

    public AjaxResult getOutStorePageList(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                          @RequestParam(required = false,defaultValue = "5")Integer pageSize,
                                          OutStoreDTO outStoreDTO){
        ListVo<OutStoreVo> outStoreVoList=outStoreService.getOutStorePageList(pageNum,pageSize,outStoreDTO);
        return AjaxResult.success(outStoreVoList);
    }

    @PutMapping("/outstore-confirm")
    public AjaxResult confirmOutStore(@RequestBody OutStoreVo outStoreVo){
        return outStoreService.confirmOutStore(outStoreVo)?AjaxResult.success():AjaxResult.fail();
    }
}
