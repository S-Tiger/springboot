package com.starho.springboot.test.vo.board;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="board") //JPA 어노테이션 테이블 이름
public class BoardVo {

    @Id //JPA 어노테이션 PK로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동생성 + Auto_increment
    private Long boardNo;

    private String title;

    private String content;

    private String author;

    @Builder
    public BoardVo(String title, String content){
        this.title = title;
        this.content = content;

    }


}
