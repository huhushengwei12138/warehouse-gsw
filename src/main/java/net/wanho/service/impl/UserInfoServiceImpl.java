package net.wanho.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.netty.util.internal.StringUtil;
import net.wanho.dto.AddUserDTO;
import net.wanho.dto.AssignRoleDTO;
import net.wanho.dto.UserInfoDTO;
import net.wanho.dto.UpdateUserDTO;
import net.wanho.mapper.UserRoleMapper;
import net.wanho.po.Role;
import net.wanho.po.UserInfo;
import net.wanho.po.UserRole;
import net.wanho.service.UserInfoService;
import net.wanho.mapper.UserInfoMapper;
import net.wanho.util.CurrentUserUtil;
import net.wanho.vo.UserInfoVo;
import net.wanho.vo.ListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 32093
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

@Autowired
private UserInfoMapper userInfoMapper;
@Autowired
private UserRoleMapper userRoleMapper;

    @Override
    public UserInfoVo getUserInfo() {
        Integer userId = CurrentUserUtil.getCurrentUser();
        UserInfo userInfo = userInfoMapper.selectById(userId);
        return new UserInfoVo(userInfo.getUserId(),userInfo.getUserCode(),userInfo.getUserName());
    }

    @Override
    public ListVo<UserInfo> getUserList(int pageNum, int pageSize, UserInfoDTO userInfoDTO) {
        Page<UserInfo> page=new Page<>(pageNum,pageSize);
       QueryWrapper<UserInfo> wrapper=new QueryWrapper<>();
       wrapper.eq(!StringUtil.isNullOrEmpty(userInfoDTO.getUserCode()),"u.user_code", userInfoDTO.getUserCode());
        wrapper.eq(!StringUtil.isNullOrEmpty(userInfoDTO.getUserId()),"u.user_id", userInfoDTO.getUserId());
        wrapper.eq(!StringUtil.isNullOrEmpty(userInfoDTO.getUserState()),"u.user_state", userInfoDTO.getUserState());
        this.baseMapper.selectByPage(page, wrapper);
        ListVo<UserInfo> listVo = new ListVo(page.getCurrent(), page.getSize(), page.getTotal(), page.getCurrent(), page.getPages(), page.getRecords());
        listVo.getResultList().forEach(item->item.setGetCode(this.baseMapper.selectById(item.getCreateBy()).getUserCode()));
        return listVo;
    }

    @Override
    public boolean addUser(AddUserDTO addUserDTO) {
        if(addUserDTO.getUserPwd().equals(addUserDTO.getComfirmPassword())){
            throw new RuntimeException("确认密码输入错误");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserCode(addUserDTO.getUserCode());
        userInfo.setUserName(addUserDTO.getUserName());
        userInfo.setUserPwd(SecureUtil.md5(addUserDTO.getUserPwd()));
        userInfo.setUserState("1");
        userInfo.setCreateBy(1);
        int flag = this.baseMapper.insert(userInfo);
        return flag>0;
    }

    @Override
    public boolean updUser(UpdateUserDTO updateUserDTO) {
        UserInfo userInfo = this.baseMapper.selectById(updateUserDTO.getUserId());
        Date date = new Date();
        userInfo.setUpdateTime(date);
        userInfo.setUserCode(userInfo.getUserCode());
        userInfo.setUserName(userInfo.getUserName());
        return this.baseMapper.updateById(userInfo)>0;
    }

    @Override
    public boolean updUserState(UserInfo userInfo) {
        Date date = new Date();
        userInfo.setUpdateTime(date);
        int upd = this.baseMapper.updateById(userInfo);
        return upd>0;
    }

    @Override
    public boolean deleteUserById(String id) {
        UserInfo userInfo = this.baseMapper.selectById(id);
        userInfo.setIsDelete("1");

        return this.baseMapper.updateById(userInfo)>0;
    }

    @Override
    public boolean deleteBatch(String[] ids) {

        return userInfoMapper.deleteBatch(ids);
    }

    @Override
    public boolean updatePwd(String id) {
        UserInfo userInfo = this.baseMapper.selectById(id);
        userInfo.setUserPwd(SecureUtil.md5("111111"));
        return this.baseMapper.updateById(userInfo)>0;
    }

    @Override
    public List<Role> getUserRoleList(String id) {
        List<Role> userRoleList=userInfoMapper.getUserRoleList(id);
        return userRoleList;
    }

    @Override
    public boolean assignRole(AssignRoleDTO assignRoleDTO) {
        String[] roleCheckList = assignRoleDTO.getRoleCheckList();
        for (int i = 0; i < roleCheckList.length; i++) {
            int id=userInfoMapper.selectRoleIdByRoleName(roleCheckList[i]);
            UserRole userRole = new UserRole();
            userRole.setRoleId(id);
            userRole.setUserId(Integer.parseInt(assignRoleDTO.getUserId()));
            userRoleMapper.insert(userRole);
        }

        return true;
    }

    @Override
    public Integer[] getAuth(String userId) {
        Integer[] auths=userInfoMapper.getAuth(userId);
        return auths;
    }

    @Override
    public UserInfo queryById(String id) {
        UserInfo userInfo = this.baseMapper.selectById(id);
        return userInfo;
    }


}




