package net.wanho.controller;

import net.wanho.po.Place;
import net.wanho.service.PlaceService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    @GetMapping("/place-list")
    public AjaxResult getPlaceList(){
       List<Place> placeList= placeService.getPlaceList();
        return AjaxResult.success(placeList);
    }

    @GetMapping("/place-page-list")
    public AjaxResult getPlacePageList(@RequestParam(required = false,defaultValue = "1")int pageNum,
                                       @RequestParam(required = false,defaultValue = "5")int pageSize,
                                       String palceName,String placeNum){
       ListVo<Place> placeListVo= placeService.getPlacePageList(pageNum,pageSize,palceName,placeNum);
        return AjaxResult.success(placeListVo);
    }
}
