package net.wanho.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.CheckBatch;
import net.wanho.service.CheckBatchService;
import net.wanho.mapper.CheckBatchMapper;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【check_batch(盘点批次表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
public class CheckBatchServiceImpl extends ServiceImpl<CheckBatchMapper, CheckBatch>
    implements CheckBatchService{

}




