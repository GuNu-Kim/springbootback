package com.gunu.todolist.service.implement;

import com.gunu.todolist.dto.request.auth.SignUpRequestDto;
import com.gunu.todolist.dto.response.ResponseDto;
import com.gunu.todolist.dto.response.auth.SignUpReponseDto;
import com.gunu.todolist.entity.UserEntity;
import com.gunu.todolist.repository.UserRepository;
import com.gunu.todolist.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    /*
     * 제어의역전(IOC), 의존성주입(DI) 설명

        빈으로 등록된(@Service,@Repository) 컴포넌트를
        @Autowired로 생성한 객체에에 주입서 인스턴스를 자동으로 생성 해준다(IOC)

        주입(DI)하는 방법은 필드, 생성자, 세터메소드 3가지가 있다
        필드, 세터메소드는 인스턴스가 빈 경우가 생기는데,
        생성자는 인스턴스가 비어서 생성되는 경우가 없기 떄문에 권장 된다
        또 생성자방식은 @Autowired가 안 걸려있어도 주입을 자동으로 해준다

        lombok을 사용하는 경우 @RequiredArgsConstructor 걸고
        필드방식에 Final이 있으면 생성자를 알아서 생성 해준다

        @Autowired
        private final UserRepository userRepository;  //필드

        public AuthServiceImplement(UserRepository userRepository) {    //생성자
            this.userRepository = userRepository;
        }

        @Autowired
        public void setUserRepository(UserRepository userRepository) {  //세터메소드
            this.userRepository = userRepository;
        }
     */

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpReponseDto> signUp(SignUpRequestDto dto) {

        try {
            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if(existedEmail) return  SignUpReponseDto.DuplicateEmail();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname) return SignUpReponseDto.DuplicateNickname();

            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if(existedTelNumber) return SignUpReponseDto.DuplicateTelNumber();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpReponseDto.success();
    }
}
