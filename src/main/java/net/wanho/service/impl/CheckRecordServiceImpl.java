package net.wanho.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.CheckRecord;
import net.wanho.service.CheckRecordService;
import net.wanho.mapper.CheckRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【check_record(盘点记录表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
public class CheckRecordServiceImpl extends ServiceImpl<CheckRecordMapper, CheckRecord>
    implements CheckRecordService{

}




