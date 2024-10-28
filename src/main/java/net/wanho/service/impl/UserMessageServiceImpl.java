package net.wanho.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.UserMessage;
import net.wanho.service.UserMessageService;
import net.wanho.mapper.UserMessageMapper;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【user_message(用户站内信关系表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage>
    implements UserMessageService{

}




