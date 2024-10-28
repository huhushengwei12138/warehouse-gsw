package net.wanho.service;

import net.wanho.dto.AddUserDTO;
import net.wanho.dto.AssignRoleDTO;
import net.wanho.dto.UserInfoDTO;
import net.wanho.dto.UpdateUserDTO;
import net.wanho.po.Role;
import net.wanho.po.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import net.wanho.vo.UserInfoVo;
import net.wanho.vo.ListVo;

import java.util.List;

/**
* @author 32093
* @description 针对表【user_info(用户表)】的数据库操作Service
* @createDate 2024-10-18 17:03:49
*/
public interface UserInfoService extends IService<UserInfo> {

    UserInfoVo getUserInfo();


    ListVo<UserInfo> getUserList(int pageNum, int pageSize, UserInfoDTO userInfoDTO);

    boolean addUser(AddUserDTO addUserDTO);

    boolean updUser(UpdateUserDTO updateUserDTO);

    UserInfo queryById(String id);

    boolean updUserState(UserInfo userInfo);

    boolean deleteUserById(String id);

    boolean deleteBatch(String[] ids);

    boolean updatePwd(String id);

    List<Role> getUserRoleList(String id);

    boolean assignRole(AssignRoleDTO assignRoleDTO);

    Integer[] getAuth(String userId);
}
