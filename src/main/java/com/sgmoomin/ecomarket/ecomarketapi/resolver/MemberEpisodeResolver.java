package com.sgmoomin.ecomarket.ecomarketapi.resolver;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

import com.sgmoomin.ecomarket.ecomarketapi.domain.Member;
import com.sgmoomin.ecomarket.ecomarketapi.domain.MemberEpisode;
import com.sgmoomin.ecomarket.ecomarketapi.dto.MemberDto;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberEpisodeResolver {
// implements GraphQLResolver<Member>{
    // public MemberEpisode episode(){
    //     log.info("request episode data for Member id : {}");
    //     log.info("episode no of requests : {}");

    //     LocalDate nowDate = LocalDate.now();
    //     Instant instant = nowDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
    //     Date date = Date.from(instant);
		
    //     return new MemberEpisode(1, "scalar test", date);
    // } 
}
