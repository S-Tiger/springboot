package com.starho.springboot.test.service;

import com.starho.springboot.test.vo.board.BoardVo;
import com.starho.springboot.test.vo.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardVo> findAll(){
        List<BoardVo> boards = new ArrayList<>();
        boardRepository.findAll().forEach(e -> boards.add(e));
        return boards;

    }



    public Optional<BoardVo> findById(Long boardNo){
        Optional<BoardVo> board = boardRepository.findById(boardNo);
        return board;
    }

    public void deleteById(Long boardNo){
        boardRepository.deleteById(boardNo);
    }

    public BoardVo save(BoardVo board){
        boardRepository.save(board);
        return board;
    }

    public void updateById(Long boardNo, BoardVo board){
        Optional<BoardVo> e = boardRepository.findById(boardNo);

        if(e.isPresent()){
            e.get().setBoardNo(board.getBoardNo());
            e.get().setTitle(board.getTitle());
            e.get().setContent(board.getContent());
            e.get().setAuthor(board.getAuthor());
            boardRepository.save(board);
        }

    }
}

