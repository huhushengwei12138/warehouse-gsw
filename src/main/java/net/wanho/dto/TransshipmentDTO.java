package net.wanho.dto;

import lombok.Data;

@Data
public class TransshipmentDTO {
    private String targetStoreId;
    private String sourceStoreId;
    private String targetProductName;
    private String sourceProductName;
    private String createName;
}
