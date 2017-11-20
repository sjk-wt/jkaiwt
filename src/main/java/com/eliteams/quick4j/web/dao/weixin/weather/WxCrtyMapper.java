package com.eliteams.quick4j.web.dao.weixin.weather;

import com.eliteams.quick4j.web.model.weixin.weather.WxCrty;
import com.eliteams.quick4j.web.model.weixin.weather.WxCrtyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxCrtyMapper {
    int countByExample(WxCrtyExample example);

    int deleteByExample(WxCrtyExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxCrty record);

    int insertSelective(WxCrty record);

    List<WxCrty> selectByExampleWithBLOBs(WxCrtyExample example);

    List<WxCrty> selectByExample(WxCrtyExample example);

    WxCrty selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxCrty record, @Param("example") WxCrtyExample example);

    int updateByExampleWithBLOBs(@Param("record") WxCrty record, @Param("example") WxCrtyExample example);

    int updateByExample(@Param("record") WxCrty record, @Param("example") WxCrtyExample example);

    int updateByPrimaryKeySelective(WxCrty record);

    int updateByPrimaryKeyWithBLOBs(WxCrty record);

    int updateByPrimaryKey(WxCrty record);
}