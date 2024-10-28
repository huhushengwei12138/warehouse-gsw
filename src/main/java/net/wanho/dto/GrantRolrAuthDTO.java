package net.wanho.dto;

import lombok.Data;

@Data
public class GrantRolrAuthDTO {
    private String roleId;
    private Integer[] authIds;
}
