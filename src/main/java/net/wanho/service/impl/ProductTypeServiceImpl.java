package net.wanho.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.mapper.ProductMapper;
import net.wanho.po.AuthInfo;
import net.wanho.po.Product;
import net.wanho.po.ProductType;
import net.wanho.service.ProductService;
import net.wanho.service.ProductTypeService;
import net.wanho.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author 32093
* @description 针对表【product_type(商品分类表)】的数据库操作Service实现
* @createDate 2024-10-18 17:03:49
*/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType>
    implements ProductTypeService{
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductType> getproductCateTree() {
        List<ProductType> list=this.list();
        List<ProductType> productTypeList=list.stream().filter(item->
            item.getParentId()==0
        ).map(item->{
            findChildren(item,list);
            return item;
        }).collect(Collectors.toList());
        System.out.println(productTypeList);
        return productTypeList;
    }

    @Override
    public ProductType verifyTypeCode(String typeCode) {
        return this.getOne(new LambdaQueryWrapper<ProductType>().eq(ProductType::getTypeCode,typeCode));
    }

    @Override
    public boolean addType(ProductType productType) {
        return this.baseMapper.insert(productType)>0;
    }

    @Override
    public ProductType queryProductTypeById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public boolean updateProductType(ProductType productType) {
        return this.baseMapper.updateById(productType)>0;
    }

    @Override
    public boolean deleteProductType(Integer id) {
        boolean flag = productMapper.exists(new LambdaQueryWrapper<Product>().eq(Product::getTypeId, id));
        if(flag){
            throw new RuntimeException("有关联的商品未被删除");
        }
        List<Integer> ids=new ArrayList<>();
        ids.add(id);
        findProductypeChildren(id,ids);



        return this.removeBatchByIds(ids);
    }

    private void findChildren(ProductType item, List<ProductType> list) {
        if(!ObjectUtil.isEmpty(list)){
            List<ProductType> children = list.stream()
                    .filter(subitem -> subitem.getParentId().equals(item.getTypeId()))
                    .map(sub -> {
                        findChildren(sub, list);
                        return sub;
                    }).collect(Collectors.toList());
            item.setChildProductCategory(children);
        }

    }

    private void findProductypeChildren(Integer id, List<Integer> childrenProtype) {
        List<ProductType> list = this.list(new LambdaQueryWrapper<ProductType>().eq(ProductType::getParentId, id));
        if(!ObjectUtil.isEmpty(list)){
            list.forEach(item->{
                childrenProtype.add(item.getTypeId());
                findProductypeChildren(item.getTypeId(),childrenProtype);

            });

        }


    }
}




