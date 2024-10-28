package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 采购单表
 * @TableName buy_list
 */
@TableName(value ="buy_list")
@Data
public class BuyList implements Serializable {
    /**
     * 采购单id
     */
    @TableId(type = IdType.AUTO)
    private Integer buyId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 预计采购数量
     */
    private Integer buyNum;

    /**
     * 实际采购数量
     */
    private Integer factBuyNum;

    /**
     * 采购时间
     */
    private Date buyTime;

    /**
     * 供应商id
     */
    private Integer supplyId;

    /**
     * 产地id
     */
    private Integer placeId;

    /**
     * 采购人名
     */
    private String buyUser;

    /**
     * 采购人电话
     */
    private String phone;

    /**
     * 入库状态：0 否 1 是
     */
    private String isIn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}