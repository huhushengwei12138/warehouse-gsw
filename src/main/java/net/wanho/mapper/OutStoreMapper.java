package net.wanho.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.po.OutStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.vo.OutStoreVo;

/**
* @author 32093
* @description 针对表【out_store(出库单表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:49
* @Entity net.wanho.po.OutStore
*/
public interface OutStoreMapper extends BaseMapper<OutStore> {

    Page<OutStoreVo> getOutStorePageList(Page<OutStoreVo> page, QueryWrapper<OutStoreVo> wrapper);
}




