package net.wanho.controller;


import net.wanho.dto.AddUserDTO;
import net.wanho.dto.AssignRoleDTO;
import net.wanho.dto.UserInfoDTO;
import net.wanho.dto.UpdateUserDTO;
import net.wanho.po.AuthInfo;
import net.wanho.po.Role;
import net.wanho.po.UserInfo;
import net.wanho.service.AuthInfoService;
import net.wanho.service.UserInfoService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private AuthInfoService authInfoService;
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping("/auth-list")
    public AjaxResult getAuthList(){
        List<AuthInfo> AuthList=authInfoService.getUserAuthList();
        return AjaxResult.success("获取用户权限列表成功",AuthList);
    }

    @GetMapping("/user-list")
    public AjaxResult getRoleList(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                  @RequestParam(required = false,defaultValue = "5")Integer pageSize,
                                  UserInfoDTO userInfoDTO){

        ListVo userInfos = userInfoService.getUserList(pageNum,pageSize, userInfoDTO);

        return AjaxResult.success(userInfos);
    }

    @PostMapping("/addUser")

    public AjaxResult addUser(@RequestBody AddUserDTO addUserDTO){
        userInfoService.addUser(addUserDTO);
        return AjaxResult.success("添加用户成功");
    }

    @PutMapping("/updateState")

    public AjaxResult updateState(@RequestBody UserInfo userInfo){
        boolean b = userInfoService.updUserState(userInfo);
        return b?AjaxResult.success("修改用户状态成功"):AjaxResult.fail("修改用户失败");
    }

    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable String id){
        UserInfo userInfo=userInfoService.queryById(id);
        return AjaxResult.success(userInfo);
    }

    @PutMapping("/updateUser")

    public AjaxResult updateUser(@RequestBody UpdateUserDTO updateUserDTO){
        boolean b = userInfoService.updUser(updateUserDTO);
        return b?AjaxResult.success("修改用户成功"):AjaxResult.fail("修改用户失败");
    }

    @DeleteMapping("deleteUser/{id}")
    public AjaxResult deleteUserById(@PathVariable String id){
       return userInfoService.deleteUserById(id)?AjaxResult.success("删除用户成功"):AjaxResult.fail("删除用户失败");
    }

    @DeleteMapping("/deleteUserList")
    public AjaxResult deleteBatch(@RequestBody String[] ids){

        return userInfoService.deleteBatch(ids)?AjaxResult.success("批量删除用户成功"):AjaxResult.fail("批量删除用户成功");
    }

    @PutMapping("/updatePwd/{id}")
    public AjaxResult updatePwd(@PathVariable String id){
        return userInfoService.updatePwd(id)?AjaxResult.success("重置密码成功"):AjaxResult.fail("重置密码失败");
    }

    @GetMapping("/user-role-list/{id}")
    public AjaxResult getUserRoleList(@PathVariable String id){
        List<Role> userRoleList=userInfoService.getUserRoleList(id);
        return AjaxResult.success("获取用户角色列表成功",userRoleList);
    }

    @PutMapping("/assignRole")
    public AjaxResult assignRole(@RequestBody AssignRoleDTO assignRoleDTO){
      return   userInfoService.assignRole(assignRoleDTO)?AjaxResult.success("分配角色成功"):AjaxResult.fail("分配角色失败");

    }

    @GetMapping("/user-auth")
    public AjaxResult getAuth(@RequestParam String userId){
        Integer[] auths=userInfoService.getAuth(userId);
        return AjaxResult.success("null",auths);
    }
    @GetMapping("/exportTable")

    public AjaxResult exportTable(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                                  UserInfoDTO userInfoDTO){
        return AjaxResult.success();
    }

}
