package net.wanho.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 调货单表
 * @TableName transshipment
 */
@TableName(value ="transshipment")
@Data
public class Transshipment implements Serializable {
    /**
     * 调货单id
     */
    @TableId(type = IdType.AUTO)
    private Integer transId;

    /**
     * 源仓库id
     */
    private Integer sourceStoreId;

    /**
     * 源商品id
     */
    private Integer sourceProductId;

    /**
     * 目标仓库id
     */
    private Integer targetStoreId;

    /**
     * 目标商品id
     */
    private Integer targetProductId;

    /**
     * 调货量
     */
    private Integer transNum;

    /**
     * 审核状态：0 未审核 1 已审核
     */
    private String auditState;

    /**
     * 创建人id
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)

    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}