package com.eliteams.quick4j.web.service.impl.weixin.sgin;

import com.eliteams.quick4j.web.dao.weixin.sgin.WeixinUserMapper;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinUser;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinUserExample;
import com.eliteams.quick4j.web.service.weixin.sgin.WeixinUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hccl on 2017/11/17.
 */
@Service
public class WeixinUserServiceImpl implements WeixinUserService {

    @Resource
    private WeixinUserMapper weixinUserMapper;

    @Override
    public int countByExample(WeixinUserExample example) {
        return weixinUserMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(WeixinUserExample example) {
        return weixinUserMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return weixinUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WeixinUser record) {
        return weixinUserMapper.insert(record);
    }

    @Override
    public int insertSelective(WeixinUser record) {
        return weixinUserMapper.insertSelective(record);
    }

    @Override
    public List<WeixinUser> selectByExample(WeixinUserExample example) {
        return weixinUserMapper.selectByExample(example);
    }

    @Override
    public WeixinUser selectByPrimaryKey(String id) {
        return weixinUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(WeixinUser record, WeixinUserExample example) {
        return weixinUserMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(WeixinUser record, WeixinUserExample example) {
        return weixinUserMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(WeixinUser record) {
        return weixinUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WeixinUser record) {
        return weixinUserMapper.updateByPrimaryKey(record);
    }
}
