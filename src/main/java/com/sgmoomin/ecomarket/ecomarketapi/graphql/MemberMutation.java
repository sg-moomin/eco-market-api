package com.sgmoomin.ecomarket.ecomarketapi.graphql;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sgmoomin.ecomarket.ecomarketapi.domain.Member;
// import com.sgmoomin.ecomarket.ecomarketapi.domain.MemberHist;
// import com.sgmoomin.ecomarket.ecomarketapi.dto.MemberHistDto;
import com.sgmoomin.ecomarket.ecomarketapi.repository.MemberHistRepository;
import com.sgmoomin.ecomarket.ecomarketapi.repository.MemberRepository;
import com.sgmoomin.ecomarket.ecomarketapi.service.MaskingService;

import graphql.kickstart.tools.GraphQLMutationResolver;

// import com.coxautodev.graphql.tools.GraphQLMutationResolver;
// import com.sgmoomin.ecomarket.ecomarketapi.repository.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberMutation implements GraphQLMutationResolver {

	private final MemberRepository memberRepository;

	private final MemberHistRepository memberHistRepository;

	private final MaskingService maskingService;
	
	/**
	 * 
	 * 회원 등록
	 * 
	 * @param memberSn
	 * @param memberId
	 * @param memberEmail
	 * @param memberNumber
	 * @return
	 */
	public Member registerMember(int memberSn, String memberId, String memberEmail, String memberNumber) {
		
		Member newMember = Member.builder()
				.membersn(memberSn)
				.memberid(memberId)
				.memberemail(memberEmail)
				.membernumber(memberNumber).build();
		
		return memberRepository.save(newMember);
	}

	/**
	 * 회원 삭제
	 * 
	 * @param memberId
	 * @return
	 */	
	public Boolean deleteMember(String memberId) {
		List<Member> memberList = memberRepository.findAll();
		int deleteChk = 0;
		
		for(Member member : memberList) {
			if(member.getMemberid().equals(memberId)) {
				memberRepository.delete(member);
				deleteChk += 1;
			}
		}
		
		if(deleteChk > 0) {
			return true;
		} else {
			return false;			
		}
	}

	/**
	 *  맴버 email 마스킹 처리 요청
	 * 	-> save() -> insert/update 둘다 처리 
	 * 
	 * @param memberid
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Boolean updateMemberEmailMask(String memberid) throws Exception{
		
		// 1. 맴버 이메일 조회
		List<Member> memberList = memberRepository.findAll();
		// MemberHistDto memberHistDto = new MemberHistDto();
		
		for(Member member : memberList){
			if(member.getMemberid().equals(memberid)){
				// 2. 이메일 마스킹 처리
				String memberEmail = maskingService.maskingMemberEmail(member.getMemberemail());

				// 3. 마스킹 된 이메일 업데이트
				// // 3.1 이력 먼저 insert -> 변경 전 데이터 
				// MemberHist memberHist = new MemberHist();
				// int histSn = this.selectMemberHistSn(member);
				// memberHist = memberHistDto.fromMemberHist(member, histSn);
				// memberHistRepository.save(memberHist);
				
				// 3.2 이력 insert 완료 후 date 변경
				int chk = memberRepository.updateMemberEmailMask(memberid, memberEmail);
				
				// 4. 업데이트 체크 
				if(chk == 0){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 맴버 이력 테이블 조회 및 채번 
	 * 
	 * @param member
	 * @return
	 * @throws Exception
	 */	
	private int selectMemberHistSn(Member member) throws Exception{
		// return memberHistRepository.selectMemberHistSn(member.getMembersn());
		return 0;
	}


}
