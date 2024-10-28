package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 盘点表
 * @TableName store_check
 */
@TableName(value ="store_check")
@Data
public class StoreCheck implements Serializable {
    /**
     * 盘点id
     */
    @TableId(type = IdType.AUTO)
    private Integer checkId;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 记录id
     */
    private Integer recordId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 批次id
     */
    private Integer batchId;

    /**
     * 盘点商品数
     */
    private BigDecimal checkNum;

    /**
     * 盘点日期
     */
    private Date checkTime;

    /**
     * 盘点负责人
     */
    private String checkUser;

    /**
     * 损失商品数
     */
    private BigDecimal lossNum;

    /**
     * 盘点损失的原因
     */
    private String reson;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}