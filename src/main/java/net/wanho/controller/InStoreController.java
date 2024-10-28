package net.wanho.controller;

import net.wanho.dto.InStoreDTO;
import net.wanho.po.InStore;
import net.wanho.service.InStoreService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.InStoreVO;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instore")
public class InStoreController {

    @Autowired
    private InStoreService inStoreService;
    @GetMapping("/instore-page-list")
    public AjaxResult getInstorePageList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                         @RequestParam(required = false,defaultValue = "5")Integer pageSize,
                                         InStoreDTO inStoreDTO){
        ListVo<InStoreVO> inStoreVOList=inStoreService.getInstorePageList(pageNum,pageSize,inStoreDTO);
        return AjaxResult.success(inStoreVOList);

    }

    @PutMapping("/instore-confirm")
    public AjaxResult confirmInstore(@RequestBody InStore inStore){
        return inStoreService.confirmInstore(inStore)?AjaxResult.success("入库成功"):AjaxResult.fail("入库失败");
    }
}
