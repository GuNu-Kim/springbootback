package com.gunu.todolist.dto.response.board;

import com.gunu.todolist.common.ResponseCode;
import com.gunu.todolist.common.ResponseMessage;
import com.gunu.todolist.dto.object.BoardListItem;
import com.gunu.todolist.dto.response.ResponseDto;
import com.gunu.todolist.entity.BoardListViewEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class GetLatestBoardListResponseDto extends ResponseDto {

    private List<BoardListItem> latestList;
    private GetLatestBoardListResponseDto(List<BoardListViewEntity> boardEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = BoardListItem.getList(boardEntities);
    }

    public static ResponseEntity<GetLatestBoardListResponseDto> seccess(List<BoardListViewEntity> boardEntities) {
        GetLatestBoardListResponseDto result = new GetLatestBoardListResponseDto(boardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
