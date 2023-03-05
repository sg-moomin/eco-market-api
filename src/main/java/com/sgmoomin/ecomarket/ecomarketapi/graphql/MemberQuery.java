package com.sgmoomin.ecomarket.ecomarketapi.graphql;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sgmoomin.ecomarket.ecomarketapi.domain.Member;
import com.sgmoomin.ecomarket.ecomarketapi.dto.MemberDto;
import com.sgmoomin.ecomarket.ecomarketapi.repository.MemberRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberQuery implements GraphQLQueryResolver{
	
	private final MemberRepository memberRepository;
	
	public Member findMembers(String memberId) {

		Member result = new Member();
		List<Member> members = memberRepository.findAll().stream()
		.filter(key ->key.getMemberid().equals(memberId)).collect(Collectors.toList());

		if(members.size() > 1){
			for(Member newMember : members){
				if(newMember.getMemberid().equals(memberId)){
					return newMember;
				}
			}	
			return null;
		} else {
			Member newsMember = new Member();
			MemberDto memberDto = MemberDto.fromSelectOneMember(members, 0);
			newsMember = MemberDto.fromMemberDtoToMember(memberDto);
			return newsMember;
		}
		// List<Member> members = memberRepository.findAll();
		// Member member = new Member();
		// for(Member newMember : members) {
		// 	if(newMember.getMemberid().equals(memberId)) {
		// 		member = memberRepository.findById(newMember.getMembersn())
		// 				.orElse(null);
		// 	}
		// }
		// result = 
		// return member;
//		return MemberDto.fromMember(member);
	}
	
	public List<Member> allFindMembers(){
		
		List<Member> member = memberRepository.findAll();
		
		return member;
//		return MemberDto.fromMemberList(member);
	}
}
