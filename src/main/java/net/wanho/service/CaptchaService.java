package net.wanho.service;

import net.wanho.dto.LoginDTO;
import net.wanho.vo.CaptchaVo;
import org.springframework.stereotype.Service;


public interface CaptchaService {
    CaptchaVo getCaptcha();

    String getJwt(LoginDTO loginDTO);
}
