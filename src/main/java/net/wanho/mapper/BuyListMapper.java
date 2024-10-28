package net.wanho.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.po.BuyList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.vo.BuyListVO;
import org.apache.ibatis.annotations.Param;

/**
* @author 32093
* @description 针对表【buy_list(采购单表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:48
* @Entity net.wanho.po.BuyList
*/
public interface BuyListMapper extends BaseMapper<BuyList> {

    Page<BuyListVO> getPurchasePageList(Page<BuyListVO> page,@Param("ew") QueryWrapper<BuyList> wrapper);
}




