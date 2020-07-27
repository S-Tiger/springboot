package com.starho.springboot.test.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member") //JPA 어노테이션 테이블 이름
public class MemberVo {

    @Id //JPA 어노테이션 PK로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동생성 + Auto_increment
    private Long mbrNo;

    private String id;

    private String name;

    @Builder
    public MemberVo(String id, String name){
        this.id = id;
        this.name = name;

    }


}
