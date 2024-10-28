package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 入库单表
 * @TableName in_store
 */
@TableName(value ="in_store")
@Data
public class InStore implements Serializable {
    /**
     * 入库单id
     */
    @TableId(type = IdType.AUTO)
    private Integer insId;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 入库数量
     */
    private Integer inNum;

    /**
     * 创建用户id
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 入库状态：0 否 1 是
     */
    private String isIn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}