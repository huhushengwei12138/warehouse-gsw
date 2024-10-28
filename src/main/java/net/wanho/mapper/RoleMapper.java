package net.wanho.mapper;

import net.wanho.po.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 32093
* @description 针对表【role(角色表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:49
* @Entity net.wanho.po.Role
*/
public interface RoleMapper extends BaseMapper<Role> {

    Integer[] getRoleAuthList(String id);
}



