package net.wanho.service;

import net.wanho.po.Place;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.ListVo;

import java.util.List;

/**
* @author 32093
* @description 针对表【place(产地表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface PlaceService extends IService<Place> {

    List<Place> getPlaceList();

    ListVo<Place> getPlacePageList(int pageNum, int pageSize, String palceName, String placeNum);
}
