package com.example.photo.Controller;

import com.example.photo.Entity.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    com.example.photo.Service.boardService boardService;

    @GetMapping("/board")
    public String getBoard(){
        return "list";
    }

    @GetMapping("/write")
    public String getWrite(){
        return "Board/write";
    }

    @PostMapping("/write")
    public String postWrite(board board, Model model){

        boardService.write(board);
        model.addAttribute("message", "글 작성이 완료되었습니다");
        model.addAttribute("searchUrl", "/list");

        return "/message";
    }

    @GetMapping("/list")
    public String boardList(Model model,
                            @PageableDefault(page = 0, size = 10, sort = "no", direction = Sort.Direction.DESC) Pageable pageable,
                                String searchKeywoard ) {

        Page<board> list = null;
        if(searchKeywoard == null){
             list = boardService.boardList(pageable);
        }else {
             list = boardService.boardsearchList(searchKeywoard, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 3, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage );

        return "/Board/list";
    }

    @GetMapping("/detail")
    public String boardDetail(Model model, Integer no) {

        model.addAttribute("detail", boardService.boardDetail(no));
        return "/Board/detail";
    }

    @GetMapping("/delete")
    public String boardDelete(Integer no){
        boardService.boardDelete(no);

        return "redirect:/list";
    }

    @GetMapping("/modify/{no}")
    public String boardModify(@PathVariable("no") Integer no, Model model){

        model.addAttribute("modify", boardService.boardDetail(no));

        return "/Board/modify";
    }

    @PostMapping("/update/{no}")
    public String boardUpdate(@PathVariable("no") Integer no, board board, Model model){

        boardService.write(board);
        model.addAttribute("message", "글 수정이 완료되었습니다");
        model.addAttribute("searchUrl", "/list");

        return "/message";
    }
}
