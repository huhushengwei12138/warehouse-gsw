package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.GrantRolrAuthDTO;
import net.wanho.po.RoleAuth;
import net.wanho.service.RoleAuthService;
import net.wanho.mapper.RoleAuthMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 32093
* @description 针对表【role_auth(角色权限表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthMapper, RoleAuth>
    implements RoleAuthService{
    @Override
    public boolean grantRoleAuth(GrantRolrAuthDTO grantRolrAuthDTO) {
        this.baseMapper.delete(new QueryWrapper<RoleAuth>().eq(!ObjectUtil.isEmpty(grantRolrAuthDTO.getRoleId()),"role_id",grantRolrAuthDTO.getRoleId()));
        Integer[] authIds = grantRolrAuthDTO.getAuthIds();
        List<RoleAuth> roleAuthList=new ArrayList<>();
        for (int i = 0; i < authIds.length; i++) {
            RoleAuth roleAuth = new RoleAuth();
            roleAuth.setAuthId(authIds[i]);
            roleAuth.setRoleId(Integer.parseInt(grantRolrAuthDTO.getRoleId()));
            roleAuthList.add(roleAuth);
        }
        return this.saveBatch(roleAuthList);
    }

}




