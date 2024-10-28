package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 规格单位表
 * @TableName unit
 */
@TableName(value ="unit")
@Data
public class Unit implements Serializable {
    /**
     * 规格单位id
     */
    @TableId(type = IdType.AUTO)
    private Integer unitId;

    /**
     * 规格单位名
     */
    private String unitName;

    /**
     * 规格单位描述
     */
    private String unitDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}