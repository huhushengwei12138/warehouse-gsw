package net.wanho.controller;

import net.wanho.dto.StoreInfoDTO;
import net.wanho.po.Store;
import net.wanho.service.StoreService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
     private StoreService storeService;
    @GetMapping("/store-list")
    public AjaxResult getStoreList(){
        List<Store> storeList= storeService.list();
        return AjaxResult.success(storeList);
    }

    @GetMapping("/store-page-list")
    public AjaxResult getStorePageList(@RequestParam(required = false,defaultValue = "1")int pageNum,
                                       @RequestParam(required = false,defaultValue ="1")int pageSize,
                                       StoreInfoDTO storeInfoDTO){
        ListVo<Store> storeList=storeService.listByPage(pageNum,pageSize,storeInfoDTO);
        return AjaxResult.success(storeList);
    }

    @PostMapping("/store-add")

    public AjaxResult addStore(@RequestBody Store store){
        return storeService.addStore(store)?AjaxResult.success("添加仓库成功"):AjaxResult.fail("添加仓库失败");
    }

    @GetMapping("/store-num-check")
    public AjaxResult checkStoreNum(String id){
        Store store=storeService.checkStoreNum(id);
        return AjaxResult.success(store);
    }
}
