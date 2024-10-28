package net.wanho.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.dto.TransshipmentDTO;
import net.wanho.po.Transshipment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.vo.OutStoreVo;
import net.wanho.vo.TransshipmentVo;
import org.apache.ibatis.annotations.Param;

/**
* @author 32093
* @description 针对表【transshipment(调货单表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:49
* @Entity net.wanho.po.Transshipment
*/
public interface TransshipmentMapper extends BaseMapper<Transshipment> {

    Page<TransshipmentVo> getTeansshipmentPageList(Page<TransshipmentVo> page, @Param("ew") QueryWrapper<TransshipmentDTO> wrapper);
}




