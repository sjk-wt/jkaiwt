package com.eliteams.quick4j.web.dao.weixin.sgin;

import com.eliteams.quick4j.web.model.weixin.sgin.WeixinUser;
import com.eliteams.quick4j.web.model.weixin.sgin.WeixinUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeixinUserMapper {
    int countByExample(WeixinUserExample example);

    int deleteByExample(WeixinUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(WeixinUser record);

    int insertSelective(WeixinUser record);

    List<WeixinUser> selectByExample(WeixinUserExample example);

    WeixinUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WeixinUser record, @Param("example") WeixinUserExample example);

    int updateByExample(@Param("record") WeixinUser record, @Param("example") WeixinUserExample example);

    int updateByPrimaryKeySelective(WeixinUser record);

    int updateByPrimaryKey(WeixinUser record);
}