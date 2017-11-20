package com.eliteams.quick4j.web.service.weixin.pojo;

import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfig;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hccl on 2017/11/20.
 */
public interface WeixinConfigService {

    int countByExample(WeixinConfigExample example);

    int deleteByExample(WeixinConfigExample example);

    int deleteByPrimaryKey(String wxToken);

    int insert(WeixinConfig record);

    int insertSelective(WeixinConfig record);

    List<WeixinConfig> selectByExample(WeixinConfigExample example);

    WeixinConfig selectByPrimaryKey(String wxToken);

    int updateByExampleSelective(@Param("record") WeixinConfig record, @Param("example") WeixinConfigExample example);

    int updateByExample(@Param("record") WeixinConfig record, @Param("example") WeixinConfigExample example);

    int updateByPrimaryKeySelective(WeixinConfig record);

    int updateByPrimaryKey(WeixinConfig record);
}
