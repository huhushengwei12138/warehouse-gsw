package net.wanho.service;

import net.wanho.dto.UpdateAuthDTO;
import net.wanho.po.AuthInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 32093
* @description 针对表【auth_info(权限表)】的数据库操作Service
* @createDate 2024-10-18 17:03:48
*/
public interface AuthInfoService extends IService<AuthInfo> {

    List<AuthInfo> getUserAuthList();

    List<AuthInfo> getAuthList();

    AuthInfo checkAuthName(String authName);

    AuthInfo checkAuthUrl(String authUrl);

    AuthInfo checkAuthCode(String authCode);

    boolean addAuthInfo(AuthInfo authInfo);

    boolean updEnableAuthState(String id);

    boolean updDisableAuthState(String id);

    boolean updateAuth(UpdateAuthDTO updateAuthDTO);

    boolean deleteAuth(Integer id);
}
