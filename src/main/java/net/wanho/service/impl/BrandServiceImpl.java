package net.wanho.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.po.Brand;
import net.wanho.service.BrandService;
import net.wanho.mapper.BrandMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 32093
* @description 针对表【brand(品牌表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:48
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{

    @Override
    public List<Brand> getBrandList() {
        return this.list();
    }
}




