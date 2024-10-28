package net.wanho.dto;

import lombok.Data;

import java.util.Date;
@Data
public class AddPurchaseDTO {
     private String productId;
    private String  productName;
    private String  storeId;
    private String storeName;
    private String supplyId;
    private String supplyName;
    private String       placeId;
    private String         placeName;
    private String       buyNum;
    private String        buyUser;
    private String        phone;
    private String        brandId;
    private String       brandName;
    private String       productNum;
    private String       productInvent;
    private String      typeId;
    private String      typeName;
    private String       unitId;
    private String      unitName;
    private String      introduce;
    private String      upDownState;
    private String       inPrice;
    private String       salePrice;
    private String       memPrice;
    private Date       createTime;
    private Date       updateTime;
    private Integer      createBy;
    private Integer     updateBy;
    private String      imgs;
    private String     productDate;
    private Date suppDate;
    private String      isOverDate;
}
