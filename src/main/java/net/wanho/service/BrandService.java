package net.wanho.service;

import net.wanho.po.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 32093
* @description 针对表【brand(品牌表)】的数据库操作Service
* @createDate 2024-10-18 17:03:48
*/
public interface BrandService extends IService<Brand> {

    List<Brand> getBrandList();
}
