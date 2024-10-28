package net.wanho.dto;

import lombok.Data;

@Data
public class UpdateAuthDTO {
    private String authId;
    private String authName;
    private String authDesc;
}
