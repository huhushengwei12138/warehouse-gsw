package net.wanho.controller;

import net.wanho.dto.LoginDTO;
import net.wanho.service.CaptchaService;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.CaptchaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/captchaImage")
    public AjaxResult getCaptcha(){
        CaptchaVo captchaVo=captchaService.getCaptcha();
        return AjaxResult.success(captchaVo);
    }




}
