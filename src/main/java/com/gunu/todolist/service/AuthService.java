package com.gunu.todolist.service;

import com.gunu.todolist.dto.request.auth.SignInRequestDto;
import com.gunu.todolist.dto.request.auth.SignUpRequestDto;
import com.gunu.todolist.dto.response.auth.SignInResponseDto;
import com.gunu.todolist.dto.response.auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
