package com.sgmoomin.ecomarket.ecomarketapi.domain;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Builder
@Value
@Setter
@Getter
@AllArgsConstructor
@Entity(name="memberepisode")
public class MemberEpisode{

    @Id
    private int mepisNo;
    private String title;
    private LocalDate regDate;
    // private Long randomUID;
}

