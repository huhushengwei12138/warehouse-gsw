package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 品牌表
 * @TableName brand
 */
@TableName(value ="brand")
@Data
public class Brand implements Serializable {
    /**
     * 品牌id
     */
    @TableId(type = IdType.AUTO)
    private Integer brandId;

    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 品牌首字母
     */
    private String brandLeter;

    /**
     * 品牌描述
     */
    private String brandDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}