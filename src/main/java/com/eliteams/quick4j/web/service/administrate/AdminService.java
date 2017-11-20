package com.eliteams.quick4j.web.service.administrate;

import com.eliteams.quick4j.web.model.administrate.Admin;
import com.eliteams.quick4j.web.model.administrate.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hccl on 2017/10/24.
 */
public interface AdminService {

    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}
