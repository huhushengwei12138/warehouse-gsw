package net.wanho.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductVO {
    private Integer productId;

    /**
     * 仓库id,仓库名
     */
    private Integer storeId;
    private String storeName;

    /**
     * 品牌id,品牌名
     */
    private Integer brandId;
    private String brandName;


    /**
     * 商品名
     */
    private String productName;

    /**
     * 商品代号
     */
    private String productNum;

    /**
     * 库存量
     */
    private Integer productInvent;

    /**
     * 商品分类id,商品分类名
     */
    private Integer typeId;
    private String typeName;
    /**
     * 供应商id,供应商名
     */
    private Integer supplyId;
    private String supplyName;

    /**
     * 产地id，产地名
     */
    private Integer placeId;
    private String placeName;

    /**
     * 规格单位id,规格单位名
     */
    private Integer unitId;
    private String unitName;

    /**
     * 商品介绍
     */
    private String introduce;

    /**
     * 上下架状态：0 下架 1 上架
     */
    private String upDownState;

    /**
     * 入库价格
     */
    private BigDecimal inPrice;

    /**
     * 售价
     */
    private BigDecimal salePrice;

    /**
     * 会员价
     */
    private BigDecimal memPrice;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人id
     */
    private Integer createBy;

    /**
     * 更新人id
     */
    private Integer updateBy;

    /**
     * 商品图片
     */
    private String imgs;

    /**
     * 生产日期
     */
    private Date productDate;

    /**
     * 保质期
     */
    private Date suppDate;

    /**
     * 阈值
     */
    private Integer threshold;
}
