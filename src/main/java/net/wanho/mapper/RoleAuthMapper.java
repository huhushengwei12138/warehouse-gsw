package net.wanho.mapper;

import net.wanho.po.RoleAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 32093
* @description 针对表【role_auth(角色权限表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:49
* @Entity net.wanho.po.RoleAuth
*/
@Mapper
public interface RoleAuthMapper extends BaseMapper<RoleAuth> {

}




