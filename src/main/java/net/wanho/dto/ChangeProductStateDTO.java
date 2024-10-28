package net.wanho.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
public class ChangeProductStateDTO {
    private String productId;
    private String upDownState;
}
