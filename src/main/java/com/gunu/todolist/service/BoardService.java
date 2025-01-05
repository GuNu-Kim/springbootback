package com.gunu.todolist.service;

import com.gunu.todolist.dto.request.board.PostBoardRequestDto;
import com.gunu.todolist.dto.response.board.PostBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}
