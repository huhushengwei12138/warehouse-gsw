package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String userCode;

    /**
     * 用户昵称(姓名)
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 用户状态:0 禁用 、1 启用
     */
    private String userState;

    /**
     * 删除状态：0 正常、 1 已删除
     */
    private String isDelete;

    /**
     * 创建人id
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private String getCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}