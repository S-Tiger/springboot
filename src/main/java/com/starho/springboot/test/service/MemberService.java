package com.starho.springboot.test.service;

import com.starho.springboot.test.vo.MemberRepository;
import com.starho.springboot.test.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<MemberVo> finaAll(){
        List<MemberVo> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;

    }

    public Optional<MemberVo> findById(Long mbrNo){
        Optional<MemberVo> member = memberRepository.findById(mbrNo);
        return member;
    }

    public void deleteById(Long mbrNo){
        memberRepository.deleteById(mbrNo);
    }

    public MemberVo save(MemberVo member){
        memberRepository.save(member);
        return member;
    }

    public void updateById(Long mbrNo, MemberVo member){
        Optional<MemberVo> e = memberRepository.findById(mbrNo);

        if(e.isPresent()){
            e.get().setMbrNo(member.getMbrNo());
            e.get().setId(member.getId());
            e.get().setName(member.getName());
            memberRepository.save(member);
        }

    }
}