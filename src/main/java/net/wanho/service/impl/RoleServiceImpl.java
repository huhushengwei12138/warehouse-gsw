package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.AddRoleDTO;
import net.wanho.dto.GrantRolrAuthDTO;
import net.wanho.dto.RoleInfoDTO;
import net.wanho.dto.UpdateRoleDTO;
import net.wanho.po.Role;
import net.wanho.po.RoleAuth;
import net.wanho.service.RoleService;
import net.wanho.mapper.RoleMapper;
import net.wanho.vo.ListVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 32093
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{



    @Override
    public List<Role> getRoleList() {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Role::getRoleState,"1");
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public ListVo<Role> getrolePageList(Page<Role> page, RoleInfoDTO roleInfoDTO) {
        QueryWrapper<Role> wrapper=new QueryWrapper<>();
        wrapper.like(!ObjectUtil.isEmpty(roleInfoDTO.getRoleCode()),"role_code",roleInfoDTO.getRoleCode());
        wrapper.eq(!ObjectUtil.isEmpty(roleInfoDTO.getRoleName()),"role_name",roleInfoDTO.getRoleName());
        wrapper.eq(!ObjectUtil.isEmpty(roleInfoDTO.getRoleState()),"role_state",roleInfoDTO.getRoleState());
        this.page(page,wrapper);
        ListVo<Role> roleListVo = new ListVo<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.maxLimit(),page.getRecords());
        roleListVo.getResultList().forEach(item->item.setGetCode(this.baseMapper.selectById(item.getCreateBy()).getRoleCode()));


        return roleListVo;
    }

    @Override
    public boolean addRole(AddRoleDTO addRoleDTO) {
        Role role = new Role();
        role.setRoleName(addRoleDTO.getRoleName());
        role.setRoleDesc(addRoleDTO.getRoleDesc());
        role.setRoleCode(addRoleDTO.getRoleCode());


        return this.baseMapper.insert(role)>0;
    }

    @Override
    public boolean updRoleState(Role role) {

        return  this.baseMapper.updateById(role)>0;
    }

    @Override
    public Role queryById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public boolean updRole(UpdateRoleDTO updateRoleDTO) {
        Role role = this.baseMapper.selectById(updateRoleDTO.getRoleId());
        role.setRoleName(updateRoleDTO.getRoleName());
        role.setRoleDesc(updateRoleDTO.getRoleDesc());
        return this.baseMapper.updateById(role)>0;
    }

    @Override
    public boolean deleteRoleById(String id) {


        return this.baseMapper.deleteById(id)>0;
    }

    @Override
    public Integer[] getRoleAuthList(String id) {
        return this.baseMapper.getRoleAuthList(id);
    }


}




