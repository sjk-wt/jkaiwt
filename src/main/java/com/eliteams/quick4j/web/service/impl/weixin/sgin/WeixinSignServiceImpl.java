package com.eliteams.quick4j.web.service.impl.weixin.sgin;

import com.eliteams.quick4j.web.dao.weixin.sgin.WeixinSignMapper;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinSign;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinSignExample;
import com.eliteams.quick4j.web.service.weixin.sgin.WeixinSignService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by hccl on 2017/11/17.
 */
@Service
public class WeixinSignServiceImpl implements WeixinSignService {

    @Resource
    private WeixinSignMapper weixinSignMapper;

    @Override
    public int countByExample(WeixinSignExample example) {
        return weixinSignMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(WeixinSignExample example) {
        return weixinSignMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return weixinSignMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WeixinSign record) {
        return weixinSignMapper.insert(record);
    }

    @Override
    public int insertSelective(WeixinSign record) {
        return weixinSignMapper.insertSelective(record);
    }

    @Override
    public List<WeixinSign> selectByExample(WeixinSignExample example) {
        return weixinSignMapper.selectByExample(example);
    }

    @Override
    public WeixinSign selectByPrimaryKey(String id) {
        return weixinSignMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(WeixinSign record, WeixinSignExample example) {
        return weixinSignMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(WeixinSign record, WeixinSignExample example) {
        return weixinSignMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(WeixinSign record) {
        return weixinSignMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WeixinSign record) {
        return weixinSignMapper.updateByPrimaryKey(record);
    }

    @Override
    public int isTodaySigned(@Param("record") WeixinSign record) {
        return weixinSignMapper.isTodaySigned(record);
    }

    @Override
    public int isMondeySigned(Map<String, String> map) {
        return weixinSignMapper.isMondeySigned(map);
    }
}
