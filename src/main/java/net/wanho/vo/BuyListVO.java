package net.wanho.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BuyListVO {

    private Integer buyId;

    /**
     * 商品id,商品名
     */
    private Integer productId;
    private String productName;

    /**
     * 仓库id,仓库名
     */
    private Integer storeId;
    private String storeName;

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

}
