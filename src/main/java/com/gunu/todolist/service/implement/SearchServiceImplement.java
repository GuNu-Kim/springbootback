package com.gunu.todolist.service.implement;

import com.gunu.todolist.dto.response.ResponseDto;
import com.gunu.todolist.dto.response.search.GetPopularListResponseDto;
import com.gunu.todolist.repository.SearchLogRepository;
import com.gunu.todolist.repository.resultSet.GetPopularListResultSet;
import com.gunu.todolist.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService {

    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {

        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try {
            resultSets = searchLogRepository.getPopularList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPopularListResponseDto.success(resultSets);
    }
}
