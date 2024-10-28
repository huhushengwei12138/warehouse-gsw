package net.wanho.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class InStoreDTO {
    private String storeId;
    private String productName;
   
    private String startTime;

    private String endTime;
}
