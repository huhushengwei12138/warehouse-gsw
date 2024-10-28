package net.wanho.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class TransshipmentVo {

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

    private Integer createBy;

    /**
     * 创建时间
     */


    private Date createTime;

    private String createName;
    private String sourceProductName;
    private String sourceStoreName;
    private String  targetProductName;
    private String  targetStoreName;

}
