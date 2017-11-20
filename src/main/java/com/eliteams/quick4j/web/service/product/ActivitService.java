package com.eliteams.quick4j.web.service.product;

import com.eliteams.quick4j.web.model.product.Activit;
import com.eliteams.quick4j.web.model.product.ActivitExample;
import com.eliteams.quick4j.web.model.product.ActivitWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by hccl on 2017/10/17.
 */
public interface ActivitService {

    int countByExample(ActivitExample example);

    int deleteByExample(ActivitExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActivitWithBLOBs record);

    int insertSelective(ActivitWithBLOBs record);

    List<ActivitWithBLOBs> selectByExampleWithBLOBs(ActivitExample example);

    List<Activit> selectByExample(ActivitExample example);

    List<ActivitWithBLOBs> selectByExampleWithBLOBsByMessage(Map<String, String> map);

    ActivitWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActivitWithBLOBs record, @Param("example") ActivitExample example);

    int updateByExampleWithBLOBs(@Param("record") ActivitWithBLOBs record, @Param("example") ActivitExample example);

    int updateByExample(@Param("record") Activit record, @Param("example") ActivitExample example);

    int updateByPrimaryKeySelective(ActivitWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ActivitWithBLOBs record);

    int updateByPrimaryKey(Activit record);
}
