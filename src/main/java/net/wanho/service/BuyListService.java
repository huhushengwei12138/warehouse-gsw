package net.wanho.service;

import net.wanho.dto.PurchaseDTO;
import net.wanho.po.BuyList;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.BuyListVO;
import net.wanho.vo.ListVo;

/**
* @author 32093
* @description 针对表【buy_list(采购单表)】的数据库操作Service
* @createDate 2024-10-18 17:03:48
*/
public interface BuyListService extends IService<BuyList> {

    ListVo<BuyListVO> getPurchasePageList(Integer pageNum, Integer pageSize, PurchaseDTO purchaseDTO);



    boolean addPurchase(BuyList buyList);

    boolean updatePurchase(BuyList buyList);

    boolean addPurchaseRecord(BuyList buyList);

    boolean deletePurchase(String id);
}
