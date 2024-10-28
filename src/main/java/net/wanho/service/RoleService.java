package net.wanho.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.dto.AddRoleDTO;
import net.wanho.dto.GrantRolrAuthDTO;
import net.wanho.dto.RoleInfoDTO;
import net.wanho.dto.UpdateRoleDTO;
import net.wanho.po.AuthInfo;
import net.wanho.po.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.ListVo;

import java.util.List;

/**
* @author 32093
* @description 针对表【role(角色表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface RoleService extends IService<Role> {


    List<Role> getRoleList();

    ListVo<Role> getrolePageList(Page<Role> page, RoleInfoDTO roleInfoDTO);

    boolean addRole(AddRoleDTO addRoleDTO);

    boolean updRoleState(Role role);

    Role queryById(String id);

    boolean updRole(UpdateRoleDTO updateRoleDTO);

    boolean deleteRoleById(String id);

    Integer[] getRoleAuthList(String id);


}
