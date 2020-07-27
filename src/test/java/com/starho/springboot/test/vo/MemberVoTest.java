package com.starho.springboot.test.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberVoTest {

    @Test
    public void getId(){
        final MemberVo memberVo = MemberVo.builder()
                .id("sungho")
                .name("test")
                .build();
        final String id = memberVo.getId();
        assertEquals("sungho", id);
        //assertEquals(a,b) A와 B의 값이 일치 하는지 확인한다.
        //assertSame(a,b) A와 B가 같은 객체임을 확인한다. ==
        //assertTrue(a) A가 참인가 확인한다.
        //assertNotNull(a) A가 null이 아님을 확인한다.
    }


    @Test
    public void getName(){
        final MemberVo memberVo = MemberVo.builder()
                .id("sungho")
                .name("test")
                .build();
        final String name = memberVo.getName();
        assertEquals("test", name);
    }
}