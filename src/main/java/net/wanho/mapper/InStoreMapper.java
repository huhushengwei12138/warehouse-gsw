package net.wanho.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.po.InStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.vo.InStoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 32093
* @description 针对表【in_store(入库单表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:48
* @Entity net.wanho.po.InStore
*/
@Mapper
public interface InStoreMapper extends BaseMapper<InStore> {

    Page<InStoreVO> getInstorePageList(Page<InStoreVO> inStorePage,@Param("ew") QueryWrapper<InStoreVO> wrapper);
}




