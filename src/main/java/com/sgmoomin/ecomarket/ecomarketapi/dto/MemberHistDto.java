package com.sgmoomin.ecomarket.ecomarketapi.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sgmoomin.ecomarket.ecomarketapi.domain.Member;
import com.sgmoomin.ecomarket.ecomarketapi.domain.MemberHist;

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
public class MemberHistDto {

	private int memberSn;
	private int histSn;
	private String memberId;
	private String memberEmail;
	private String memberNumber;
	private Date regdt;
	private Date upddt;
	
	
	public MemberHist fromMemberHist(Member member, int histsn) throws ParseException{
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
		String curTime = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss").format(Calendar.getInstance().getTime());
		Date todayDate = simpleFormat.parse(curTime);
		System.out.println("todayDate : " + todayDate);


		return MemberHist.builder()
				.membersn(member.getMembersn())
				.histsn(histsn)
				.memberid(member.getMemberid())
				.memberemail(member.getMemberemail())
				.membernumber(member.getMembernumber())
				.regdt(todayDate)
				.upddt(todayDate)
				.build();
	
	}
}
