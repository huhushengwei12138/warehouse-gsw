package net.wanho.service;

import net.wanho.dto.InStoreDTO;
import net.wanho.po.InStore;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.InStoreVO;
import net.wanho.vo.ListVo;

/**
* @author 32093
* @description 针对表【in_store(入库单表)】的数据库操作Service
* @createDate 2024-10-18 17:03:48
*/
public interface InStoreService extends IService<InStore> {

    ListVo<InStoreVO> getInstorePageList(Integer pageNum, Integer pageSize, InStoreDTO inStoreDTO);

    boolean confirmInstore(InStore inStore);
}
