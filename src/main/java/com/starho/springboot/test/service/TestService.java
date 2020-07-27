package com.starho.springboot.test.service;

import com.starho.springboot.test.mapper.TestMapper;
import com.starho.springboot.test.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TestMapper testMapper;

    public List<TestVo> selectTest(){
        return testMapper.selectTest();
    }

    public List<TestVo> logtest(){

        logger.trace("Trace Level 테스트");
        logger.debug("DEBUG Level 테스트");
        logger.info("INFO Level 테스트");
        logger.warn("Warn Level 테스트");
        logger.error("ERROR Level 테스트");


        return testMapper.selectTest();
    }
}
