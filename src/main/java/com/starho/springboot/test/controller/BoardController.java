package com.starho.springboot.test.controller;

import com.starho.springboot.test.service.BoardService;
import com.starho.springboot.test.vo.board.BoardVo;
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
@RequestMapping("board")
public class BoardController {

    //기본형
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BoardService boardService;

    //모든 회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardVo>> getAllmembers(){
        List<BoardVo> board = boardService.findAll();
        return new ResponseEntity<List<BoardVo>>(board, HttpStatus.OK );

    }

    //회원번호로 한명의 회원 표시
    @GetMapping(value = "/{boardNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardVo> getBoard(@PathVariable("boardNo") Long boardNo){
        Optional<BoardVo> board = boardService.findById(boardNo);
        return new ResponseEntity<BoardVo>(board.get(),HttpStatus.OK);
    }

    //회원번호로 회원 삭제
    @DeleteMapping(value = "/{boardNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteMember(@PathVariable("boardNo") Long boardNo){
        boardService.deleteById(boardNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //회원번호로 회원 수정 (mbrNo로 회원을 찾아 member 객체의 id,name으로 수정함)
    @PutMapping(value = "/{boardNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardVo> updateMember(@PathVariable("boardNo") Long boardNo, @RequestBody BoardVo board){
        boardService.updateById(boardNo,board);
        return new ResponseEntity<BoardVo>(board, HttpStatus.OK);
    }

    //회원 입력
    @PostMapping
    public ResponseEntity<BoardVo> save(@RequestBody BoardVo board){
        return new ResponseEntity<BoardVo>(boardService.save(board),HttpStatus.OK);
    }

    //회원입력
    @RequestMapping(value = "/saveMember", method = RequestMethod.GET)
    public ResponseEntity<BoardVo> save(HttpServletRequest request, BoardVo board){
        return new ResponseEntity<BoardVo>(boardService.save(board), HttpStatus.OK);
    }


}


