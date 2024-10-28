package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 产地表
 * @TableName place
 */
@TableName(value ="place")
@Data
public class Place implements Serializable {
    /**
     * 产地id
     */
    @TableId(type = IdType.AUTO)
    private Integer placeId;

    /**
     * 产地名
     */
    private String placeName;

    /**
     * 产地代码
     */
    private String placeNum;

    /**
     * 产地介绍
     */
    private String introduce;

    /**
     * 删除状态：0:可用  1:不可用
     */
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}