package net.wanho.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer storeId;
    private String productName;
    private String brandName;
    private String typeName;
    private String supplyName;
    private String placeName;
    private Integer upDownState;
    private Integer isOverDate;

}
