package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 盘点记录表
 * @TableName check_record
 */
@TableName(value ="check_record")
@Data
public class CheckRecord implements Serializable {
    /**
     * 记录id
     */
    @TableId(type = IdType.AUTO)
    private Integer recordId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 批次id
     */
    private Integer batchId;

    /**
     * 盘点状态：1 盘点完成  0 未盘点
     */
    private String checkState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}