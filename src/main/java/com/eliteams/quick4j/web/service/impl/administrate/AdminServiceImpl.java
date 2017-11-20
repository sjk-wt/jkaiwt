package com.eliteams.quick4j.web.service.impl.administrate;

import com.eliteams.quick4j.web.dao.administrate.AdminMapper;
import com.eliteams.quick4j.web.model.administrate.Admin;
import com.eliteams.quick4j.web.model.administrate.AdminExample;
import com.eliteams.quick4j.web.service.administrate.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hccl on 2017/10/24.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int countByExample(AdminExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Admin record) {
        return 0;
    }

    @Override
    public int insertSelective(Admin record) {
        return 0;
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return adminMapper.selectByExample(example);
    }

    @Override
    public Admin selectByPrimaryKey(String id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Admin record, AdminExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return 0;
    }
}
