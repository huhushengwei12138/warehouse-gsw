package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 盘点批次表
 * @TableName check_batch
 */
@TableName(value ="check_batch")
@Data
public class CheckBatch implements Serializable {
    /**
     * 批次id
     */
    @TableId(type = IdType.AUTO)
    private Integer batchId;

    /**
     * 批总量
     */
    private String batchNum;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建的用户名
     */
    private String createUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}