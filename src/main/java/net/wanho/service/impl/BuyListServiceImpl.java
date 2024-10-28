package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.PurchaseDTO;
import net.wanho.mapper.InStoreMapper;
import net.wanho.mapper.ProductMapper;
import net.wanho.po.BuyList;
import net.wanho.po.InStore;
import net.wanho.po.Product;
import net.wanho.service.BuyListService;
import net.wanho.mapper.BuyListMapper;
import net.wanho.util.CurrentUserUtil;
import net.wanho.vo.BuyListVO;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

/**
* @author 32093
* @description 针对表【buy_list(采购单表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
@Transactional
public class BuyListServiceImpl extends ServiceImpl<BuyListMapper, BuyList>
    implements BuyListService{

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private InStoreMapper inStoreMapper;
    @Override
    public ListVo<BuyListVO> getPurchasePageList(Integer pageNum, Integer pageSize, PurchaseDTO purchaseDTO) {
        Page<BuyListVO> page = new Page<>(pageNum,pageSize);
        QueryWrapper<BuyList> wrapper = new QueryWrapper<>();
        wrapper.eq(!ObjectUtil.isEmpty(purchaseDTO.getStoreId()),"bu.store_id",purchaseDTO.getStoreId());
        wrapper.ge(!ObjectUtil.isEmpty(purchaseDTO.getStartTime()),"bu.buy_time",purchaseDTO.getStartTime());
        wrapper.le(!ObjectUtil.isEmpty(purchaseDTO.getEndTime()),"bu.buy_time",purchaseDTO.getEndTime());
        wrapper.like(!ObjectUtil.isEmpty(purchaseDTO.getBuyUser()),"bu.buy_user",purchaseDTO.getBuyUser());
        wrapper.eq(!ObjectUtil.isEmpty(purchaseDTO.getIsIn()),"bu.is_in",purchaseDTO.getIsIn());
        page=this.baseMapper.getPurchasePageList(page,wrapper);
        ListVo<BuyListVO> buyListListVo = new ListVo<>(page.getCurrent(),page.getPages(),page.getTotal(),page.getSize(),page.maxLimit(),page.getRecords());

        return buyListListVo;
    }

    @Override
    public boolean addPurchase(BuyList buyList) {
        buyList.setIsIn("0");
        buyList.setBuyTime(new Date());
        buyList.setFactBuyNum(0);

        return this.baseMapper.insert(buyList)>0;
    }

    @Override
    public boolean updatePurchase(BuyList buyList) {

        return this.baseMapper.updateById(buyList)>0;
    }

    @Override
    public boolean addPurchaseRecord(BuyList buyList) {
        buyList.setIsIn("1");
        InStore inStore = new InStore();
        inStore.setIsIn("0");

        inStore.setCreateBy(CurrentUserUtil.getCurrentUser());
        inStore.setStoreId(buyList.getStoreId());
        inStore.setCreateTime(new Date());
        inStore.setInNum(buyList.getFactBuyNum());
        inStore.setProductId(buyList.getProductId());
        return inStoreMapper.insert(inStore)>0&&this.baseMapper.updateById(buyList)>0;
    }

    @Override
    public boolean deletePurchase(String id) {

        return this.baseMapper.deleteById(id)>0;
    }


}




