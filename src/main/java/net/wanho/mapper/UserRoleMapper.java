package net.wanho.mapper;

import net.wanho.po.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 32093
* @description 针对表【user_role(用户角色表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:49
* @Entity net.wanho.po.UserRole
*/
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}




