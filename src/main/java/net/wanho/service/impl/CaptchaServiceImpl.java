package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wf.captcha.SpecCaptcha;
import net.wanho.Constant.CaptchaConstant;
import net.wanho.dto.LoginDTO;
import net.wanho.exception.CaptchaException;
import net.wanho.mapper.UserInfoMapper;
import net.wanho.po.UserInfo;
import net.wanho.service.CaptchaService;
import net.wanho.util.JwtUtil;
import net.wanho.vo.CaptchaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public CaptchaVo getCaptcha() {
        String uuid = UUID.randomUUID().toString();
        SpecCaptcha specCaptcha = new SpecCaptcha();
        String base64 = specCaptcha.toBase64();
        String text = specCaptcha.text();
        stringRedisTemplate.opsForValue().set(CaptchaConstant.CaptchaConstant_Perfix+uuid,text,2, TimeUnit.HOURS);
        CaptchaVo captchaVo = new CaptchaVo(uuid,base64);
        return captchaVo;
    }

    @Override
    public String getJwt(LoginDTO loginDTO) {
        /*
        * 查看验证码
        *
        * */
        String key=CaptchaConstant.CaptchaConstant_Perfix+loginDTO.getUuid();
        String captchacode = stringRedisTemplate.opsForValue().get(key);
        if(ObjectUtil.isEmpty(captchacode)){
            throw new CaptchaException("验证码已过期");
        }
        stringRedisTemplate.delete(key);
        if(!loginDTO.getCode().equalsIgnoreCase(captchacode)){
            throw new CaptchaException("验证码不正确");
        }

        /*
        * 验证用户
        * */

        LambdaQueryWrapper<UserInfo> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserCode,loginDTO.getUserCode());
        queryWrapper.eq(UserInfo::getUserPwd, SecureUtil.md5(loginDTO.getUserPwd()));
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if(ObjectUtil.isEmpty(userInfo)){
            throw new CaptchaException("用户名或密码错误");
        }
        if(userInfo.getUserState().equals(CaptchaConstant.STATUS_DISABLE)){
            throw new CaptchaException("该用户名已被禁用");
        }

        Map<String,Object> map = new HashMap<>(4) ;
        map.put("userCode",userInfo.getUserCode());
        map.put("userName",userInfo.getUserName());
        map.put("userId",userInfo.getUserId());
        map.put("userPwd",userInfo.getUserPwd());
        String token = JwtUtil.generate(map);
        stringRedisTemplate.opsForValue().set("token",token);

        return "Bearer "+token;
    }
}
