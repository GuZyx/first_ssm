package com.zyx.ssm.dao;

import com.zyx.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 会员(联系人)持久层
 */

@Repository("memberDao")
public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;
}
