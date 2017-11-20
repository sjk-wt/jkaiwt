package com.eliteams.quick4j.web.service.administrate;

import com.eliteams.quick4j.core.feature.orm.mybatis.Page;
import com.eliteams.quick4j.web.model.administrate.Customer;
import com.eliteams.quick4j.web.model.administrate.CustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hccl on 2017/10/31.
 */
public interface CustomerService {

    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    List<Customer> selectByExample(Page<Customer> page, CustomerExample example);

    Customer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}
