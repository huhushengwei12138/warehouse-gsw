package net.wanho.service;

import net.wanho.dto.SupplyInfoDTO;
import net.wanho.po.Supply;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.ListVo;

import java.util.List;

/**
* @author 32093
* @description 针对表【supply(供货商表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface SupplyService extends IService<Supply> {

    List<Supply> getSupplyList();

    ListVo<Supply> getSupplyPageList(int pageNum, int pageSize, SupplyInfoDTO supplyInfoDTO);
}
