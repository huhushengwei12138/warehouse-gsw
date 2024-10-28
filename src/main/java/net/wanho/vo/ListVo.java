package net.wanho.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.wanho.po.UserInfo;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListVo<T> {
    private Long pageNum;
    private Long pageSize;
    private Long totalNum;
    private Long pageCount;
    private Long limitIndex;
    private List<T> resultList;
}
