package net.wanho.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.dto.*;
import net.wanho.po.AuthInfo;
import net.wanho.po.Role;
import net.wanho.po.UserInfo;
import net.wanho.service.RoleAuthService;
import net.wanho.service.RoleService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleAuthService roleAuthService;
    @GetMapping("/role-list")

    public AjaxResult getRoleList(){
      List<Role> roleList=  roleService.getRoleList();
      return AjaxResult.success("获取角色列表成功",roleList);
    }

    @GetMapping("/role-page-list")

    public AjaxResult getRolePageList(@RequestParam(required = false,defaultValue = "1")int pageNum,
                                      @RequestParam(required = false,defaultValue ="5")int pageSize,
                                      RoleInfoDTO roleInfoDTO){
        Page<Role> page=new Page<>(pageNum,pageSize);
        ListVo<Role> roleListVo = roleService.getrolePageList(page, roleInfoDTO);
        return AjaxResult.success("获取角色分页列表成功",roleListVo);
    }

    @PostMapping("/role-add")

    public AjaxResult addUser(@RequestBody AddRoleDTO addRoleDTO){

        return roleService.addRole(addRoleDTO)?AjaxResult.success("添加角色成功"):AjaxResult.fail("添加角色失败");
    }

    @PutMapping("/role-state-update")

    public AjaxResult updateState(@RequestBody Role role){
        boolean b = roleService.updRoleState(role);
        return b?AjaxResult.success("修改角色状态成功"):AjaxResult.fail("修改角色状态失败");
    }

    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable String id){
        Role role =roleService.queryById(id);
        return AjaxResult.success(role);
    }

    @PutMapping("/role-update")

    public AjaxResult updateUser(@RequestBody UpdateRoleDTO updateRoleDTO){

        return roleService.updRole(updateRoleDTO)?AjaxResult.success("修改角色成功"):AjaxResult.fail("修改角色失败");
    }


    @DeleteMapping("/role-delete/{id}")

    public AjaxResult deleteRoleById(@PathVariable String id){
        return roleService.deleteRoleById(id)?AjaxResult.success("删除角色成功"):AjaxResult.fail("删除角色失败");
    }

    @GetMapping("/role-auth")
    public AjaxResult getRoleAuthList(@RequestParam("roleId") String id){
        Integer[] roleAuthList = roleService.getRoleAuthList(id);
        return AjaxResult.success("获取角色权限成功",roleAuthList);
    }

    @PutMapping("/auth-grant")

    public AjaxResult grantRoleAuth(@RequestBody GrantRolrAuthDTO grantRolrAuthDTO){
        return roleAuthService.grantRoleAuth(grantRolrAuthDTO)?AjaxResult.success("分配角色权限成功"):AjaxResult.fail("分配角色权限失败");
    }

    @GetMapping("/exportTable")

    public AjaxResult exportTable(@RequestParam(required = false,defaultValue = "1")int pageNum,
                                  @RequestParam(required = false,defaultValue ="5")int pageSize,
                                  RoleInfoDTO roleInfoDTO){
        Page<Role> page=new Page<>(pageNum,pageSize);
        ListVo<Role> roleListVo = roleService.getrolePageList(page, roleInfoDTO);
        return AjaxResult.success("null",roleListVo);
    }






}
