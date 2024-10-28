package net.wanho.controller;

import net.wanho.dto.AddPurchaseDTO;
import net.wanho.dto.PurchaseDTO;
import net.wanho.po.BuyList;
import net.wanho.po.Product;
import net.wanho.service.BuyListService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.BuyListVO;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private BuyListService buyListService;
    @GetMapping("/purchase-page-list")
    public AjaxResult getPurchasePageList(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                          @RequestParam(required = false,defaultValue = "5")Integer pageSize,
                                          PurchaseDTO purchaseDTO){
        ListVo<BuyListVO> purchasePageList=buyListService.getPurchasePageList(pageNum,pageSize,purchaseDTO);
        return AjaxResult.success(purchasePageList);
    }

    @PostMapping("/purchase-add")
    public AjaxResult addPurchase(@RequestBody BuyList buyList
                                  ){
        return buyListService.addPurchase(buyList)?AjaxResult.success("添加采购单成功"):AjaxResult.fail("添加采购单失败");
    }

    @PutMapping("/purchase-update")
    public AjaxResult updatePurchase(@RequestBody BuyList buyList){
        return buyListService.updatePurchase(buyList)?AjaxResult.success("修改采购单成功"):AjaxResult.fail("修改采购单失败");
    }

    @PostMapping("/in-warehouse-record-add")
    public AjaxResult addPurchaseRecord(@RequestBody BuyList buyList){
        return buyListService.addPurchaseRecord(buyList)?AjaxResult.success("生成入库单成功"):AjaxResult.fail("生成入库单失败");
    }

    @DeleteMapping("/purchase-delete/{id}")

    public AjaxResult deletePurchase(@PathVariable String id){
        return buyListService.deletePurchase(id)?AjaxResult.success("删除入库单成功"):AjaxResult.fail("删除入库单失败");
    }

    @GetMapping("/exportTable")
    public AjaxResult exportTable(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                  @RequestParam(required = false,defaultValue = "5")Integer pageSize,
                                  PurchaseDTO purchaseDTO){
        return AjaxResult.success();
    }
}
