package com.sgmoomin.ecomarket.ecomarketapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="memberhist")
public class MemberHist{
    
	
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int membersn;

    @Id
    @Column(nullable = false)
    private int histsn;

    @Column(nullable = false)    
    private String memberid;
    
    @Column(nullable = false)
    private String memberemail;
    
    @Column(nullable = false)
    private String membernumber;
	
    @Column(nullable = false)
    private Date regdt;

    @Column(nullable = false)
    private Date upddt;

//    @OneToMany
//    @JoinColumn(name = "memberSn")
//    private List<Member> members;
}
