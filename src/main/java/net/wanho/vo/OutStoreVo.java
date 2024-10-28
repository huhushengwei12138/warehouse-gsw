package net.wanho.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OutStoreVo {
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
    private String productName;
    private String storeName;
    private String userCode;
    private String tallyName;
}
