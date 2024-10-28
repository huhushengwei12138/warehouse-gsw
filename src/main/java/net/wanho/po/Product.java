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
 * 商品表
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Integer productId;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 品牌id
     */
    private Integer brandId;

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
     * 商品分类id
     */
    private Integer typeId;

    /**
     * 供应商id
     */
    private Integer supplyId;

    /**
     * 产地id
     */
    private Integer placeId;

    /**
     * 规格单位id
     */
    private Integer unitId;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}