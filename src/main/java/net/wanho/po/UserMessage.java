package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户站内信关系表
 * @TableName user_message
 */
@TableName(value ="user_message")
@Data
public class UserMessage implements Serializable {
    /**
     * 用户站内信id
     */
    @TableId(type = IdType.AUTO)
    private Integer userMsgId;

    /**
     * 站内信id
     */
    private Integer msgId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 站内信状态：0 未读 1 已读
     */
    private String state;

    /**
     * 发信人id
     */
    private Integer fromUser;

    /**
     * 收信人id
     */
    private Integer toUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}