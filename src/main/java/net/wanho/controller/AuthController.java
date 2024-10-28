package net.wanho.controller;

import net.wanho.dto.UpdateAuthDTO;
import net.wanho.po.AuthInfo;
import net.wanho.service.AuthInfoService;
import net.wanho.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.java2d.pipe.AAShapePipe;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthInfoService authInfoService;
    @GetMapping("/auth-tree")
    public AjaxResult getAuthTree(){
        List<AuthInfo> authList = authInfoService.getAuthList();
        return AjaxResult.success(authList);
    }

    @GetMapping("/name-check")
    public AjaxResult checkAuthName(String authName){
        AuthInfo authInfo=authInfoService.checkAuthName(authName);
        return AjaxResult.success(authInfo);
    }
    @GetMapping("/url-check")
    public AjaxResult checkAuthUrl(String authUrl){
        AuthInfo authInfo=authInfoService.checkAuthUrl(authUrl);
        return AjaxResult.success(authInfo);
    }
    @GetMapping("/code-check")
    public AjaxResult checkAuthCode(String authCode){
        AuthInfo authInfo=authInfoService.checkAuthCode(authCode);
        return AjaxResult.success(authInfo);
    }

    @PostMapping("/auth-add")
    public AjaxResult addAuth(@RequestBody AuthInfo authInfo){
        return authInfoService.addAuthInfo(authInfo)?AjaxResult.success("添加权限成功"):AjaxResult.fail("添加权限失败");
    }
    @PutMapping("/auth-enable/{id}")
    public AjaxResult enableAuthState(@PathVariable String id){
        return authInfoService.updEnableAuthState(id)?AjaxResult.success("修改权限状态成功"):AjaxResult.fail("修改权限状态失败");
    }

    @PutMapping("/auth-disable/{id}")
    public AjaxResult disableAuthState(@PathVariable String id){
        return authInfoService.updDisableAuthState(id)?AjaxResult.success("修改权限状态成功"):AjaxResult.fail("修改权限状态失败");
    }

    @PutMapping("/auth-update")
    public AjaxResult updateAuth(@RequestBody UpdateAuthDTO updateAuthDTO){
        return authInfoService.updateAuth(updateAuthDTO)?AjaxResult.success("修改权限信息成功"):AjaxResult.fail("修改权限信息失败");
    }

    @DeleteMapping("/auth-delete/{id}")
    public AjaxResult deleteAuth(@PathVariable Integer id){
        return authInfoService.deleteAuth(id)?AjaxResult.success("删除权限信息成功"):AjaxResult.fail("删除权限信息失败");
    }
}
