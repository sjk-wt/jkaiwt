package com.eliteams.quick4j.web.dao.weixin.sgin;

import com.eliteams.quick4j.web.model.weixin.sgin.WeixinSign;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinSignExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WeixinSignMapper {
    int countByExample(WeixinSignExample example);

    int deleteByExample(WeixinSignExample example);

    int deleteByPrimaryKey(String id);

    int insert(WeixinSign record);

    int insertSelective(WeixinSign record);

    List<WeixinSign> selectByExample(WeixinSignExample example);

    WeixinSign selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WeixinSign record, @Param("example") WeixinSignExample example);

    int updateByExample(@Param("record") WeixinSign record, @Param("example") WeixinSignExample example);

    int updateByPrimaryKeySelective(WeixinSign record);

    int updateByPrimaryKey(WeixinSign record);

    int isTodaySigned(@Param("record") WeixinSign record);

    int isMondeySigned(Map<String, String> map);
}