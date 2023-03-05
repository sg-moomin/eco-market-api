package com.sgmoomin.ecomarket.ecomarketapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sgmoomin.ecomarket.ecomarketapi.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {


    // MemberIdUpdate
    @Transactional
    @Modifying
    @Query("update member m set m.memberemail = :memberEmail where m.memberid = :memberId")
    int updateMemberEmailMask(@Param("memberId")String memberId, @Param("memberEmail")String memberEmail) throws Exception;
    
}
