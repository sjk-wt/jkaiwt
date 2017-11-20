package com.eliteams.quick4j.web.service.impl.product;

import com.eliteams.quick4j.web.dao.product.ActivitMapper;
import com.eliteams.quick4j.web.model.product.Activit;
import com.eliteams.quick4j.web.model.product.ActivitExample;
import com.eliteams.quick4j.web.model.product.ActivitWithBLOBs;
import com.eliteams.quick4j.web.service.product.ActivitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by hccl on 2017/10/17.
 */
@Service
public class ActivitServiceImpl implements ActivitService {

    @Resource
    private ActivitMapper activitMapper;


    @Override
    public int countByExample(ActivitExample example) {
        return activitMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ActivitExample example) {
        return activitMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return activitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ActivitWithBLOBs record) {
        return activitMapper.insert(record);
    }

    @Override
    public int insertSelective(ActivitWithBLOBs record) {
        return activitMapper.insertSelective(record);
    }

    @Override
    public List<ActivitWithBLOBs> selectByExampleWithBLOBs(ActivitExample example) {
        return activitMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Activit> selectByExample(ActivitExample example) {
        return activitMapper.selectByExample(example);
    }

    @Override
    public List<ActivitWithBLOBs> selectByExampleWithBLOBsByMessage(Map<String, String> map) {
        return activitMapper.selectByExampleWithBLOBsByMessage(map);
    }

    @Override
    public ActivitWithBLOBs selectByPrimaryKey(String id) {
        return activitMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ActivitWithBLOBs record, ActivitExample example) {
        return activitMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExampleWithBLOBs(ActivitWithBLOBs record, ActivitExample example) {
        return activitMapper.updateByExampleWithBLOBs(record, example);
    }

    @Override
    public int updateByExample(Activit record, ActivitExample example) {
        return activitMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ActivitWithBLOBs record) {
        return activitMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ActivitWithBLOBs record) {
        return activitMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Activit record) {
        return activitMapper.updateByPrimaryKey(record);
    }
}
