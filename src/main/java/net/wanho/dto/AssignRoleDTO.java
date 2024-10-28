package net.wanho.dto;

import lombok.Data;
import net.wanho.po.Role;

import java.util.List;

@Data
public class AssignRoleDTO {
    private String userId;
    private String userCode;
    String[] roleCheckList;

    List<Role> roleList;
}
