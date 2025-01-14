package com.gunu.todolist.dto.response.board;

import com.gunu.todolist.common.ResponseCode;
import com.gunu.todolist.common.ResponseMessage;
import com.gunu.todolist.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IncreaseViewCountResponseDto extends ResponseDto {
    private IncreaseViewCountResponseDto() {
        super(ResponseCode.SUCCESS, ResponseCode.SUCCESS);
    }

    public static ResponseEntity<IncreaseViewCountResponseDto> success(){
        IncreaseViewCountResponseDto result = new IncreaseViewCountResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
