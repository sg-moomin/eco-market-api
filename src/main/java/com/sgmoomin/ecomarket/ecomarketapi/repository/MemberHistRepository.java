package com.sgmoomin.ecomarket.ecomarketapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgmoomin.ecomarket.ecomarketapi.domain.MemberHist;


public interface MemberHistRepository extends JpaRepository<MemberHist, Integer> {

  
   //
   // @Transactional
   // @Modifying
   // @Query("
   //          insert into memberHist 
   //          value")
   // int insertMemberHist(@Param("memberHist") MemberHist memberHist) throws Exception;
  

   // memberIdUpdate
   @Transactional
   @Query("select (count(1) + 1) from memberhist where membersn = :memberSn")
   int selectMemberHistSn(@Param("memberSn")int memberSn) throws Exception;
   
}
   
