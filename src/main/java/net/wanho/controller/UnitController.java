package net.wanho.controller;

import net.wanho.po.Unit;
import net.wanho.service.UnitService;
import net.wanho.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;
    @GetMapping("/unit-list")
    public AjaxResult getUnitList(){
        List<Unit> unitList=unitService.getUnitList();
        return AjaxResult.success(unitList);
    }
}
