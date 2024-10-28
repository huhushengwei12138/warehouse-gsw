package net.wanho.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class InStoreVO {
    private String insId;
    private String storeId;
    private String productId;
    private Integer inNum;
    private Integer createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private String isIn;
    private String productName;
    private String storeName;
    private String userCode;
    private String inPrice;
}
