package net.wanho.mapper;

import net.wanho.po.AuthInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 32093
* @description 针对表【auth_info(权限表)】的数据库操作Mapper
* @createDate 2024-10-18 17:03:48
* @Entity net.wanho.po.AuthInfo
*/
@Mapper
public interface AuthInfoMapper extends BaseMapper<AuthInfo> {

    List<AuthInfo> selectMenusById(Integer userId);
}




