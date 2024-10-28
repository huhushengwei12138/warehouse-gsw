package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.dto.SupplyInfoDTO;
import net.wanho.po.Supply;
import net.wanho.service.SupplyService;
import net.wanho.mapper.SupplyMapper;
import net.wanho.vo.ListVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 32093
* @description 针对表【supply(供货商表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class SupplyServiceImpl extends ServiceImpl<SupplyMapper, Supply>
    implements SupplyService{

    @Override
    public List<Supply> getSupplyList() {
        return this.list();
    }

    @Override
    public ListVo<Supply> getSupplyPageList(int pageNum, int pageSize, SupplyInfoDTO supplyInfoDTO) {
        Page<Supply> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Supply> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtil.isEmpty(supplyInfoDTO.getSupplyName()),"supply_name",supplyInfoDTO.getSupplyName());
        wrapper.like(!ObjectUtil.isEmpty(supplyInfoDTO.getAddress()),"address",supplyInfoDTO.getAddress());
        wrapper.like(!ObjectUtil.isEmpty(supplyInfoDTO.getConcat()),"concat",supplyInfoDTO.getConcat());
        wrapper.like(!ObjectUtil.isEmpty(supplyInfoDTO.getPhone()),"phone",supplyInfoDTO.getPhone());
        this.page(page,wrapper);
        ListVo<Supply> supplyListVo = new ListVo<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.maxLimit(),page.getRecords());


        return supplyListVo;
    }
}




