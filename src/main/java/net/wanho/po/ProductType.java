package net.wanho.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 商品分类表
 * @TableName product_type
 */
@TableName(value ="product_type")
@Data
public class ProductType implements Serializable {
    /**
     * 商品分类id
     */
    @TableId(type = IdType.AUTO)
    private Integer typeId;

    /**
     * 父类id，为0时为顶级分类
     */
    private Integer parentId;

    /**
     * 分类代码
     */
    private String typeCode;

    /**
     * 分类名
     */
    private String typeName;

    /**
     * 分类描述
     */
    private String typeDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private List<ProductType> childProductCategory;
}