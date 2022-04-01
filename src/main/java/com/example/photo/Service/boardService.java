package com.example.photo.Service;

import com.example.photo.Entity.board;
import com.example.photo.Repository.boardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class boardService {

    @Autowired
    private com.example.photo.Repository.boardRepository boardRepository;

    public void write(board board) {
        boardRepository.save(board);
    }

    public Page<board> boardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Page<board> boardsearchList(String searchKeywoard, Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeywoard, pageable);
    }

    public board boardDetail(Integer no) {
        return boardRepository.findById(no).get();
    }

    public void boardDelete(Integer no){
        boardRepository.deleteById(no);
    }



}
