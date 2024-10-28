package net.wanho.controller;

import net.wanho.dto.LoginDTO;
import net.wanho.service.CaptchaService;
import net.wanho.service.UserInfoService;
import net.wanho.util.CurrentUserUtil;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class LoginController {
    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private UserInfoService userInfoService;
    @PostMapping("/login")
    public AjaxResult userLogin(@RequestBody LoginDTO loginDTO){
        String token=captchaService.getJwt(loginDTO);
        return AjaxResult.success("登录成功",token);
    }
    @GetMapping("/curr-user")
    public AjaxResult getUserInfo(){


        UserInfoVo userInfo = userInfoService.getUserInfo();
        return AjaxResult.success(userInfo);
    }

    @DeleteMapping("/logout")
    public AjaxResult logout(){
        CurrentUserUtil.removeCurrentUser();
        return AjaxResult.success();
    }

}
