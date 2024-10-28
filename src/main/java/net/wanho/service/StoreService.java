package net.wanho.service;

import net.wanho.dto.StoreInfoDTO;
import net.wanho.po.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.ListVo;

/**
* @author 32093
* @description 针对表【store(仓库表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface StoreService extends IService<Store> {

    ListVo<Store> listByPage(int pageNum, int pageSize, StoreInfoDTO storeInfoDTO);

    boolean addStore(Store store);

    Store checkStoreNum(String id);
}
