package com.starho.springboot.test.controller;

import com.starho.springboot.test.service.BoardService;
import com.starho.springboot.test.service.MemberService;
import com.starho.springboot.test.service.TestService;
import com.starho.springboot.test.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService memberService;
    @Autowired
    TestService testService;
    @Autowired
    BoardService boardService;


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
        model.addAttribute("memberList", memberService.findAll());

        return "memberList";
    }
    @RequestMapping(value = "/memberTest/save")
    public String memberSave(){
        return "memberSave";
    }


    @RequestMapping(value = "/memberTest/update/{mbrNo}")
    public String memberUpdate(@PathVariable("mbrNo") Long mbrNo, Model model){

        model.addAttribute("memberList",memberService.findById(mbrNo).get());

        return "memberUpdate";
    }
    @RequestMapping("/boardList")
    public String boardList(Model model){
        model.addAttribute("boardList", boardService.findAll());

        return "board/boardList";
    }

    @RequestMapping(value = "/boardSave")
    public String boardSave(){
        return "board/boardSave";
    }

    @RequestMapping(value = "/board/update/{boardNo}")
    public String boardUpdate(@PathVariable("boardNo") Long boardNo, Model model){

        model.addAttribute("boardList",boardService.findById(boardNo).get());

        return "board/boardUpdate";
    }
}