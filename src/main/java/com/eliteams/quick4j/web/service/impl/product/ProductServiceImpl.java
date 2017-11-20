package com.eliteams.quick4j.web.service.impl.product;

import com.eliteams.quick4j.core.util.DateFormatUtil;
import com.eliteams.quick4j.web.dao.product.ProductMapper;
import com.eliteams.quick4j.web.model.product.Product;
import com.eliteams.quick4j.web.model.product.ProductExample;
import com.eliteams.quick4j.web.model.product.ProductWithBLOBs;
import com.eliteams.quick4j.web.service.product.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hccl on 2017/10/12.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public int countByExample(ProductExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ProductExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(ProductWithBLOBs record) {
        return 0;
    }

    @Override
    public int insertSelective(ProductWithBLOBs record) {
        return 0;
    }

    @Override
    public List<ProductWithBLOBs> selectByExampleWithBLOBs(ProductExample example) {
        return productMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return null;
    }

    @Override
    public ProductWithBLOBs selectByPrimaryKey(String id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ProductWithBLOBs record, ProductExample example) {
        return 0;
    }

    @Override
    public int updateByExampleWithBLOBs(ProductWithBLOBs record, ProductExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Product record, ProductExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(ProductWithBLOBs record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return 0;
    }
}
