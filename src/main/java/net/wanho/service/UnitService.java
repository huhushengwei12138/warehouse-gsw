package net.wanho.service;

import net.wanho.po.Unit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 32093
* @description 针对表【unit(规格单位表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface UnitService extends IService<Unit> {

    List<Unit> getUnitList();
}
