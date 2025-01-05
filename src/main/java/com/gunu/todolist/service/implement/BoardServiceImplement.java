package com.gunu.todolist.service.implement;

import com.gunu.todolist.dto.request.board.PostBoardRequestDto;
import com.gunu.todolist.dto.response.ResponseDto;
import com.gunu.todolist.dto.response.board.PostBoardResponseDto;
import com.gunu.todolist.entity.BoardEntity;
import com.gunu.todolist.entity.ImageEntity;
import com.gunu.todolist.repository.BoardRepository;
import com.gunu.todolist.repository.ImageRepository;
import com.gunu.todolist.repository.UserRepository;
import com.gunu.todolist.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email) {

        try {
            boolean existedEmail = userRepository.existsByEmail(email);
            if(!existedEmail)
                return PostBoardResponseDto.notExistUser();

            BoardEntity boardEntity = new BoardEntity(dto, email);
            boardRepository.save(boardEntity);

            int boardNumber = boardEntity.getBoardNumber();
            List<String> boardImageList = dto.getBoardImageList();
            List<ImageEntity> imageEntities = new ArrayList<>();

            for (String image : boardImageList) {
                ImageEntity imageEntity = new ImageEntity(boardNumber, image);
                imageEntities.add(imageEntity);
            }

            imageRepository.saveAll(imageEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostBoardResponseDto.success();
    }
}
