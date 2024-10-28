package net.wanho.dto;

import lombok.Data;

@Data
public class OutStoreDTO {
    private String storeId;
    private String productName;

    private String startTime;

    private String endTime;
    private String isOut;
}
