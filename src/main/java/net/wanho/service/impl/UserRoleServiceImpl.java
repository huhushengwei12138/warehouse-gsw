package net.wanho.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.UserRole;
import net.wanho.service.UserRoleService;
import net.wanho.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 32093
* @description 针对表【user_role(用户角色表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




