package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.UpdateAuthDTO;
import net.wanho.mapper.RoleAuthMapper;
import net.wanho.po.AuthInfo;
import net.wanho.po.RoleAuth;
import net.wanho.service.AuthInfoService;
import net.wanho.mapper.AuthInfoMapper;
import net.wanho.service.RoleAuthService;
import net.wanho.util.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
* @author 32093
* @description 针对表【auth_info(权限表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
public class AuthInfoServiceImpl extends ServiceImpl<AuthInfoMapper, AuthInfo>
    implements AuthInfoService{
    @Autowired
    private AuthInfoMapper authInfoMapper;
    @Autowired
    private RoleAuthMapper roleAuthMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public List<AuthInfo> getUserAuthList() {
        Integer userId = CurrentUserUtil.getCurrentUser();
        List<AuthInfo> menus =(List<AuthInfo>) redisTemplate.opsForValue().get("user:menu:" + userId);
        if (!CollectionUtils.isEmpty(menus)){
            return menus;
        }
        List<AuthInfo> AuthList = authInfoMapper.selectMenusById(userId);
        menus = AuthList.stream().filter(item -> item.getParentId() == 0)
                .map(item -> {
                            findChildren(item, AuthList);
                            return item;
                        }
                ).collect(Collectors.toList());
         redisTemplate.opsForValue().set("user:menu:" + userId,menus,12, TimeUnit.HOURS);

        return menus;
    }

    @Override
    public List<AuthInfo> getAuthList() {
        List<AuthInfo> AuthList = this.list();
        List<AuthInfo> authList = AuthList.stream().filter(item -> item.getParentId() == 0)
                .map(item -> {
                            findChildren(item, AuthList);
                            return item;
                        }
                ).collect(Collectors.toList());
        return authList;
    }

    @Override
    public AuthInfo checkAuthName(String authName) {
        AuthInfo authInfo = this.baseMapper.selectOne(new LambdaQueryWrapper<AuthInfo>().eq(AuthInfo::getAuthName, authName));
        return authInfo;
    }

    @Override
    public AuthInfo checkAuthUrl(String authUrl) {
        AuthInfo authInfo = this.baseMapper.selectOne(new LambdaQueryWrapper<AuthInfo>().eq(AuthInfo::getAuthUrl, authUrl));
        return authInfo;
    }

    @Override
    public AuthInfo checkAuthCode(String authCode) {
        AuthInfo authInfo = this.baseMapper.selectOne(new LambdaQueryWrapper<AuthInfo>().eq(AuthInfo::getAuthCode, authCode));
        return authInfo;
    }

    @Override
    public boolean addAuthInfo(AuthInfo authInfo) {
        authInfo.setAuthState("1");
        return this.baseMapper.insert(authInfo)>0;
    }

    @Override
    public boolean updEnableAuthState(String id) {
        AuthInfo authInfo = this.baseMapper.selectById(id);
        authInfo.setAuthState("1");
        return this.baseMapper.updateById(authInfo)>0;
    }

    @Override
    public boolean updDisableAuthState(String id) {
        AuthInfo authInfo = this.baseMapper.selectById(id);
        authInfo.setAuthState("0");
        return this.baseMapper.updateById(authInfo)>0;
    }

    @Override
    public boolean updateAuth(UpdateAuthDTO updateAuthDTO) {
        AuthInfo authInfo = this.baseMapper.selectById(updateAuthDTO.getAuthId());
        authInfo.setAuthName(updateAuthDTO.getAuthName());
        authInfo.setAuthDesc(updateAuthDTO.getAuthDesc());
        return this.baseMapper.updateById(authInfo)>0;
    }

    @Override
    public boolean deleteAuth(Integer id) {
        //判断用户是否被关联
        boolean flag = roleAuthMapper.exists(new LambdaQueryWrapper<RoleAuth>().eq(RoleAuth::getRoleId, id));
        if(flag){
            throw new RuntimeException("有关联数据,无法删除");
        }
        //查找相关的子权限
        List<Integer> childrenAuth=new ArrayList<>();
        childrenAuth.add(id);
       findAuthChildren(id,childrenAuth);

        return this.removeBatchByIds(childrenAuth);
    }

    private void findAuthChildren(Integer id, List<Integer> childrenAuth) {
        List<AuthInfo> list = this.list(new LambdaQueryWrapper<AuthInfo>().eq(AuthInfo::getParentId, id));
        if(!ObjectUtil.isEmpty(list)){
            list.forEach(item->{
                childrenAuth.add(item.getAuthId());
                findAuthChildren(item.getAuthId(),childrenAuth);

            });

        }


    }

    private void findChildren(AuthInfo item, List<AuthInfo> authInfoList) {
        List<AuthInfo> children = authInfoList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getAuthId()))
                .map(subItem -> {
                    findChildren(subItem, authInfoList);
                    return subItem;
                }).collect(Collectors.toList());
        item.setChildAuth(children);
    }

}




