package com.gunu.todolist.controller;

import com.gunu.todolist.dto.request.board.PostBoardRequestDto;
import com.gunu.todolist.dto.response.board.GetBoardResponseDto;
import com.gunu.todolist.dto.response.board.PostBoardResponseDto;
import com.gunu.todolist.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(@PathVariable("boardNumber") Integer boardNumber){

        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(@RequestBody @Valid PostBoardRequestDto requestBody, @AuthenticationPrincipal String email){
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }
}
