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
 * 出库单表
 * @TableName out_store
 */
@TableName(value ="out_store")
@Data
public class OutStore implements Serializable {
    /**
     * 出库单id
     */
    @TableId(type = IdType.AUTO)
    private Integer outsId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 理货员id
     */
    private Integer tallyId;

    /**
     * 出库价格
     */
    private BigDecimal outPrice;

    /**
     * 出库数量
     */
    private Integer outNum;

    /**
     * 创建用户id
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 出库状态：0 否 1 是
     */
    private String isOut;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}