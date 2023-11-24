package com.gunu.todolist.controller;

import com.gunu.todolist.dto.request.auth.SignUpRequestDto;
import com.gunu.todolist.dto.response.auth.SignUpReponseDto;
import com.gunu.todolist.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    /*
        controller는 requst(입력)을 받고 검증하고 response 주는 구역
        비즈니스로직은 Service단에서 처리가 되어야 한다
     */
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpReponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody){
        ResponseEntity<? super SignUpReponseDto> response = authService.signUp(requestBody);
        return response;
    }

}
