package com.gunu.todolist.service;

import com.gunu.todolist.dto.request.auth.SignUpRequestDto;
import com.gunu.todolist.dto.response.auth.SignUpReponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<? super SignUpReponseDto> signUp(SignUpRequestDto dto);
}
