package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 供货商表
 * @TableName supply
 */
@TableName(value ="supply")
@Data
public class Supply implements Serializable {
    /**
     * 供应商id
     */
    @TableId(type = IdType.AUTO)
    private Integer supplyId;

    /**
     * 供应商代码
     */
    private String supplyNum;

    /**
     * 供应商名
     */
    private String supplyName;

    /**
     * 供应商介绍
     */
    private String supplyIntroduce;

    /**
     * 联系人
     */
    private String concat;

    /**
     * 联系人手机号
     */
    private String phone;

    /**
     * 供应商所在地
     */
    private String address;

    /**
     * 删除状态：0 正常、 1 已删除
     */
    @TableField(value = "is_Delete")
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}