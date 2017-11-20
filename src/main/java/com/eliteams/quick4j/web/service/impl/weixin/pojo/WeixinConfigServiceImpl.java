package com.eliteams.quick4j.web.service.impl.weixin.pojo;

import com.eliteams.quick4j.web.dao.weixin.pojo.WeixinConfigMapper;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfig;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfigExample;
import com.eliteams.quick4j.web.service.weixin.pojo.WeixinConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hccl on 2017/11/20.
 */
@Service
public class WeixinConfigServiceImpl implements WeixinConfigService {

    @Resource
    private WeixinConfigMapper weixinConfigMapper;

    @Override
    public int countByExample(WeixinConfigExample example) {
        return weixinConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(WeixinConfigExample example) {
        return weixinConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String wxToken) {
        return weixinConfigMapper.deleteByPrimaryKey(wxToken);
    }

    @Override
    public int insert(WeixinConfig record) {
        return weixinConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(WeixinConfig record) {
        return weixinConfigMapper.insertSelective(record);
    }

    @Override
    public List<WeixinConfig> selectByExample(WeixinConfigExample example) {
        return weixinConfigMapper.selectByExample(example);
    }

    @Override
    public WeixinConfig selectByPrimaryKey(String wxToken) {
        return weixinConfigMapper.selectByPrimaryKey(wxToken);
    }

    @Override
    public int updateByExampleSelective(WeixinConfig record, WeixinConfigExample example) {
        return weixinConfigMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(WeixinConfig record, WeixinConfigExample example) {
        return weixinConfigMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(WeixinConfig record) {
        return weixinConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WeixinConfig record) {
        return weixinConfigMapper.updateByPrimaryKey(record);
    }
}
