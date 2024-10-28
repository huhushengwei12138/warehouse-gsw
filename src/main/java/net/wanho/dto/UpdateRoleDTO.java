package net.wanho.dto;

import lombok.Data;

@Data
public class UpdateRoleDTO {
    private Integer roleId;
    private String roleName;
    private String roleDesc;

}
