package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.Place;
import net.wanho.service.PlaceService;
import net.wanho.mapper.PlaceMapper;
import net.wanho.vo.ListVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 32093
* @description 针对表【place(产地表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class PlaceServiceImpl extends ServiceImpl<PlaceMapper, Place>
    implements PlaceService{

    @Override
    public List<Place> getPlaceList() {
        return this.list();
    }

    @Override
    public ListVo<Place> getPlacePageList(int pageNum, int pageSize, String palceName, String placeNum) {
        Page<Place> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Place> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtil.isEmpty(placeNum),"place_num",placeNum);
        wrapper.like(!ObjectUtil.isEmpty(palceName),"place_name",palceName);
        this.page(page,wrapper);
        ListVo<Place> placeListVo = new ListVo<>(page.getCurrent(),page.getPages(),page.getTotal(),page.getSize(),page.maxLimit(),page.getRecords());

        return placeListVo;
    }
}




