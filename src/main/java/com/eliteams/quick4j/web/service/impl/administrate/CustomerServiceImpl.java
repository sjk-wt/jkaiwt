package com.eliteams.quick4j.web.service.impl.administrate;

import com.eliteams.quick4j.core.feature.orm.mybatis.Page;
import com.eliteams.quick4j.web.dao.administrate.CustomerMapper;
import com.eliteams.quick4j.web.model.administrate.Customer;
import com.eliteams.quick4j.web.model.administrate.CustomerExample;
import com.eliteams.quick4j.web.service.administrate.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hccl on 2017/10/31.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int countByExample(CustomerExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(CustomerExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Customer record) {
        return 0;
    }

    @Override
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public List<Customer> selectByExample(CustomerExample example) {
        return null;
    }

    @Override
    public List<Customer> selectByExample(Page<Customer> page, CustomerExample example) {
        return customerMapper.selectByExample(page, example);
    }

    @Override
    public Customer selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Customer record, CustomerExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Customer record, CustomerExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return 0;
    }
}
