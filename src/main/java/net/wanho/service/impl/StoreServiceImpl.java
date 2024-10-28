package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.StoreInfoDTO;
import net.wanho.po.Store;
import net.wanho.service.StoreService;
import net.wanho.mapper.StoreMapper;
import net.wanho.vo.ListVo;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【store(仓库表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

    @Override
    public ListVo<Store> listByPage(int pageNum, int pageSize, StoreInfoDTO storeInfoDTO) {
        Page<Store> storePage = new Page<>(pageNum,pageSize);
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtil.isEmpty(storeInfoDTO.getStoreName()),"store_name",storeInfoDTO.getStoreName());
        wrapper.like(!ObjectUtil.isEmpty(storeInfoDTO.getStoreAddress()),"store_address",storeInfoDTO.getStoreAddress());
        wrapper.like(!ObjectUtil.isEmpty(storeInfoDTO.getConcat()),"concat",storeInfoDTO.getConcat());
        wrapper.like(!ObjectUtil.isEmpty(storeInfoDTO.getPhone()),"phone",storeInfoDTO.getPhone());
        Page<Store> page = this.page(storePage, wrapper);
        ListVo<Store> storeListVo = new ListVo<>(page.getCurrent(),page.getPages(),page.getTotal(),page.getSize(),page.maxLimit(),page.getRecords());
        return storeListVo;
    }

    @Override
    public boolean addStore(Store store) {

        return this.baseMapper.insert(store)>0;
    }

    @Override
    public Store checkStoreNum(String id) {

        return this.baseMapper.selectById(id);
    }
}




