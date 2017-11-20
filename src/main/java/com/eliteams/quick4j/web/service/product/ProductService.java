package com.eliteams.quick4j.web.service.product;

import com.eliteams.quick4j.web.model.product.Product;
import com.eliteams.quick4j.web.model.product.ProductExample;
import com.eliteams.quick4j.web.model.product.ProductWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hccl on 2017/10/12.
 */
public interface ProductService {

    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProductWithBLOBs record);

    int insertSelective(ProductWithBLOBs record);

    List<ProductWithBLOBs> selectByExampleWithBLOBs(ProductExample example);

    List<Product> selectByExample(ProductExample example);

    ProductWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProductWithBLOBs record, @Param("example") ProductExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductWithBLOBs record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    int updateByPrimaryKey(Product record);

}
