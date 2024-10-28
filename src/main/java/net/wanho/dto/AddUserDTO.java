package net.wanho.dto;

import lombok.Data;

@Data
public class AddUserDTO {
    private String userCode;
    private String userName;
    private String userPwd;
    private String comfirmPassword;
}
