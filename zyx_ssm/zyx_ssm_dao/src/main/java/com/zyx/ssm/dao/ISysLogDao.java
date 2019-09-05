package com.zyx.ssm.dao;

import com.zyx.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysLogDao")
public interface ISysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;


    @Select("select * from sysLog")
    List<SysLog> findAll();
}
