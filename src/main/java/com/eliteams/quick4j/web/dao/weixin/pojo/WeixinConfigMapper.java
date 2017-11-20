package com.eliteams.quick4j.web.dao.weixin.pojo;

import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfig;
import com.eliteams.quick4j.web.model.weixin.pojo.WeixinConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeixinConfigMapper {
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