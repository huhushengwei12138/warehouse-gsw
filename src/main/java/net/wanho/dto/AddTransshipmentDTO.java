package net.wanho.dto;

import lombok.Data;

@Data
public class AddTransshipmentDTO {
    private Integer productInvent;
    private String productName;
    private String sourceProductId;
    private String sourceStoreId;
    private String targetProductNum;
    private String targetStoreId;
    private String transNum;

}
