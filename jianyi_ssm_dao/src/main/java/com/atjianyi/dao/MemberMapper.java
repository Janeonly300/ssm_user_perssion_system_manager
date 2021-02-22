package com.atjianyi.dao;

import com.atjianyi.pojo.Member;
import org.springframework.stereotype.Repository;

/**
 * @author 简一
 * @className MemberMapper
 * @Date 2021/2/22 16:47
 **/
@Repository
public interface MemberMapper {

    /**
     * 根据id找寻会员
     * @param id
     * @return
     */
    Member findMemberById(String id);
}
