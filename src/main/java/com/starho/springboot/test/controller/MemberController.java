package com.starho.springboot.test.controller;

import com.starho.springboot.test.service.MemberService;
import com.starho.springboot.test.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController //@Controller + ResponseBody 라 생각하면 편하다
@RequestMapping("memberTest")
public class MemberController {

    //ResponseEntity타입: @RestController는 별도의 뷰를 제공하지않는 형태로 서비스를 실행하기 때문에
    //리턴 데이터가 예외적인 상황에서 문제가 발생할수 있다. 웹경우 HTTP 상태코드가 이러한 정보를 나타내는데 사용된다.
    //스프링에서 제공되는 ResponseEntity타입은 개발자가 직접 결과 데이터와 HTTP상태코드를 제어 할수 있는 클래스다.
    //404나 500같은 에러를 전송하고 싶은 데이터와 함께 전송할수 있기 때문에 좀 더 세밀한 제어가 가능해진다.
    //HttpStatus.BAD_REQUEST 400에러 메세지, .NOT_FOUND 404에러 메세지

    //기본형
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService memberService;

    //모든 회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MemberVo>> getAllmembers(){
        List<MemberVo> member = memberService.findAll();
        return new ResponseEntity<List<MemberVo>>(member, HttpStatus.OK );

    }

    //회원번호로 한명의 회원 표시
    @GetMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberVo> getMember(@PathVariable("mbrNo") Long mbrNo){
        Optional<MemberVo> member = memberService.findById(mbrNo);
        return new ResponseEntity<MemberVo>(member.get(),HttpStatus.OK);
    }

    //회원번호로 회원 삭제
    @DeleteMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Long mbrNo){
        memberService.deleteById(mbrNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //회원번호로 회원 수정 (mbrNo로 회원을 찾아 member 객체의 id,name으로 수정함)
    @PutMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberVo> updateMember(@PathVariable("mbrNo") Long mbrNo, @RequestBody MemberVo member){
        memberService.updateById(mbrNo,member);
        return new ResponseEntity<MemberVo>(member, HttpStatus.OK);
    }

    //회원 입력
    @PostMapping
    public ResponseEntity<MemberVo> save(@RequestBody MemberVo member){
        return new ResponseEntity<MemberVo>(memberService.save(member),HttpStatus.OK);
    }

    //회원입력
    @RequestMapping(value = "/saveMember", method = RequestMethod.GET)
    public ResponseEntity<MemberVo> save(HttpServletRequest request, MemberVo member){
        return new ResponseEntity<MemberVo>(memberService.save(member), HttpStatus.OK);
    }


}
