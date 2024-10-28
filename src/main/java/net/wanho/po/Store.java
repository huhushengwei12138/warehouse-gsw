package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 仓库表
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * 仓库id
     */
    @TableId(type = IdType.AUTO)
    private Integer storeId;

    /**
     * 仓库名
     */
    private String storeName;

    /**
     * 仓库代码
     */
    private String storeNum;

    /**
     * 仓库地址
     */
    private String storeAddress;

    /**
     * 联系人
     */
    private String concat;

    /**
     * 联系人电话
     */
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}