package com.sgmoomin.ecomarket.ecomarketapi.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.sgmoomin.ecomarket.ecomarketapi.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private int memberSn;
	private String memberId;
	private String memberEmail;
	private String memberNumber;
	
	public static MemberDto fromMember(Member member) {
		return MemberDto.builder()
				.memberSn(member.getMembersn())
				.memberId(member.getMemberid())
				.memberEmail(member.getMemberemail())
				.memberNumber(member.getMembernumber())
				.build();
		
	}

	public static MemberDto fromSelectOneMember(List<Member> members, int selectPoint) {
		
		return MemberDto.builder()
				.memberSn(members.get(selectPoint).getMembersn())
				.memberId(members.get(selectPoint).getMemberid())
				.memberEmail(members.get(selectPoint).getMemberemail())
				.memberNumber(members.get(selectPoint).getMembernumber())
				.build();		
	}

	public static Member fromMemberDtoToMember(MemberDto memberDto){

		return Member.builder()
		.membersn(memberDto.getMemberSn())
		.memberid(memberDto.getMemberId())
		.memberemail(memberDto.getMemberEmail())
		.membernumber(memberDto.getMemberNumber()).build();
	}


	public static List<MemberDto> fromMemberList(Collection<Member> members) {
		return members.stream().map(MemberDto::fromMember).collect(Collectors.toList());
	}

}
