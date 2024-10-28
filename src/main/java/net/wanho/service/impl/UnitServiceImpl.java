package net.wanho.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.Unit;
import net.wanho.service.UnitService;
import net.wanho.mapper.UnitMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 32093
* @description 针对表【unit(规格单位表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
    implements UnitService{

    @Override
    public List<Unit> getUnitList() {
        return this.list();
    }
}




