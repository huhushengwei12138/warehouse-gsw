package net.wanho.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 权限表
 * @TableName auth_info
 */
@TableName(value ="auth_info")
@Data
public class AuthInfo implements Serializable {
    /**
     * 权限id
     */
    @TableId(type = IdType.AUTO)
    private Integer authId;

    /**
     * 权限父id，当父id为0，表示一级权限
     */
    private Integer parentId;

    /**
     * 权限名
     */
    private String authName;

    /**
     * 权限内容描述
     */
    private String authDesc;

    /**
     * 权限等级，共3级
     */
    private Integer authGrade;

    /**
     * 权限类型：1 模块 、2  列表、 3  按钮
     */
    private String authType;

    /**
     * 权限url
     */
    private String authUrl;

    /**
     * 权限代码
     */
    private String authCode;

    /**
     * 权限顺序
     */
    private Integer authOrder;

    /**
     * 权限状态：1 启用 、0 禁用
     */
    private String authState;

    /**
     * 创建权限的用户id
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新权限的用户id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(exist = false)

    private List<AuthInfo> childAuth;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}