package net.wanho.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.wanho.po.AuthInfo;
import net.wanho.po.Role;
import net.wanho.po.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 32093
* @description 针对表【user_info(用户表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:49
* @Entity net.wanho.po.UserInfo
*/

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {



    boolean deleteBatch(String[] ids);

    List<Role> getUserRoleList(String id);

    int selectRoleIdByRoleName(String roleNme);

    Integer[] getAuth(String userId);

    Page<UserInfo> selectByPage(Page<UserInfo> page,@Param("ew") QueryWrapper<UserInfo> wrapper);
}




