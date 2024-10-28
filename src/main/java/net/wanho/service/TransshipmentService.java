package net.wanho.service;

import net.wanho.dto.AddTransshipmentDTO;
import net.wanho.dto.TransshipmentDTO;
import net.wanho.po.Transshipment;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.ListVo;
import net.wanho.vo.OutStoreVo;
import net.wanho.vo.TransshipmentVo;

/**
* @author 32093
* @description 针对表【transshipment(调货单表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface TransshipmentService extends IService<Transshipment> {

    ListVo<TransshipmentVo> getTeansshipmentPageList(Integer pageNum, Integer pageSize, TransshipmentDTO transshipmentDTO);

    boolean addTransshipment(AddTransshipmentDTO addTransshipmentDTO);

    boolean confirmTransshipment(Transshipment transshipment);
}
