package net.wanho.service;

import net.wanho.dto.GrantRolrAuthDTO;
import net.wanho.po.RoleAuth;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 32093
* @description 针对表【role_auth(角色权限表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface RoleAuthService extends IService<RoleAuth> {
    boolean grantRoleAuth(GrantRolrAuthDTO grantRolrAuthDTO);

}
