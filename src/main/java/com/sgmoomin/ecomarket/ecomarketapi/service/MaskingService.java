package com.sgmoomin.ecomarket.ecomarketapi.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaskingService {
    

    /**
     * 이메일 마스킹 처리 
     * 
     */
    public String maskingMemberEmail(String memberEmail) throws Exception{
        String regexString = "(?=.{3}).(?=.*@)";
        String maskingText = "*";
        System.out.println(memberEmail.replaceAll(regexString, maskingText));
        return memberEmail.replaceAll(regexString, maskingText);
        
    }


}
