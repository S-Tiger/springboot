package com.starho.springboot.test.controller;

import com.starho.springboot.test.service.MemberService;
import com.starho.springboot.test.service.TestService;
import com.starho.springboot.test.vo.MemberVo;
import com.starho.springboot.test.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService memberService;
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public ModelAndView test() throws Exception{
        List<TestVo> testList = testService.selectTest();

        ModelAndView mav = new ModelAndView("thymeleafTest");
        mav.addObject("list", testList);
        return mav;

    }
    @RequestMapping("/logtest")
    public ModelAndView logtest() throws Exception{

        List<TestVo> testList = testService.logtest();

        ModelAndView mav = new ModelAndView("thymeleafTest");

        logger.trace("Trace Level 테스트");
        logger.debug("DEBUG Level 테스트");
        logger.info("INFO Level 테스트");
        logger.warn("Warn Level 테스트");
        logger.error("ERROR Level 테스트");

        return mav;
    }

    @RequestMapping("/")
    public String memeberMain(Model model){
        model.addAttribute("memberList", memberService.finaAll());

        return "memberList";
    }
    @RequestMapping(value = "/memberTest/save")
    public String memberSave(){
        return "memberSave";
    }


    @RequestMapping(value = "/memberTest/update")
    public String memberUpdate(@PathVariable("mbrNo") Long mbrNo, Model model){
        Optional<MemberVo> member = memberService.findById(mbrNo);
        model.addAttribute("memberList",member);

        return "memberUpdate";
    }

}