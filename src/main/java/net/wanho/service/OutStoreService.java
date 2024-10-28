package net.wanho.service;

import net.wanho.dto.OutStoreDTO;
import net.wanho.po.OutStore;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.ListVo;
import net.wanho.vo.OutStoreVo;

import java.util.List;

/**
* @author 32093
* @description 针对表【out_store(出库单表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface OutStoreService extends IService<OutStore> {

    ListVo<OutStoreVo> getOutStorePageList(Integer pageNum, Integer pageSize, OutStoreDTO outStoreDTO);

    boolean confirmOutStore(OutStoreVo outStoreVo);
}
