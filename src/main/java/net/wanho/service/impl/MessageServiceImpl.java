package net.wanho.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.Message;
import net.wanho.service.MessageService;
import net.wanho.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【message(站内信表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




