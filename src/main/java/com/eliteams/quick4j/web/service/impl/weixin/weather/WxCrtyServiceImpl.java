package com.eliteams.quick4j.web.service.impl.weixin.weather;

import com.eliteams.quick4j.web.dao.weixin.weather.WxCrtyMapper;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrty;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrtyExample;
import com.eliteams.quick4j.web.service.weixin.weather.WxCrtyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hccl on 2017/11/20.
 */
@Service
public class WxCrtyServiceImpl implements WxCrtyService {

    @Resource
    private WxCrtyMapper wxCrtyMapper;

    @Override
    public int countByExample(WxCrtyExample example) {
        return wxCrtyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(WxCrtyExample example) {
        return wxCrtyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return wxCrtyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WxCrty record) {
        return wxCrtyMapper.insert(record);
    }

    @Override
    public int insertSelective(WxCrty record) {
        return wxCrtyMapper.insertSelective(record);
    }

    @Override
    public List<WxCrty> selectByExampleWithBLOBs(WxCrtyExample example) {
        return wxCrtyMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<WxCrty> selectByExample(WxCrtyExample example) {
        return wxCrtyMapper.selectByExample(example);
    }

    @Override
    public WxCrty selectByPrimaryKey(String id) {
        return wxCrtyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(WxCrty record, WxCrtyExample example) {
        return wxCrtyMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExampleWithBLOBs(WxCrty record, WxCrtyExample example) {
        return wxCrtyMapper.updateByExampleWithBLOBs(record, example);
    }

    @Override
    public int updateByExample(WxCrty record, WxCrtyExample example) {
        return wxCrtyMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(WxCrty record) {
        return wxCrtyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(WxCrty record) {
        return wxCrtyMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(WxCrty record) {
        return wxCrtyMapper.updateByPrimaryKey(record);
    }
}
