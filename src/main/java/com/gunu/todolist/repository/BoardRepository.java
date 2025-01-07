package com.gunu.todolist.repository;

import com.gunu.todolist.entity.BoardEntity;
import com.gunu.todolist.repository.resultSet.GetBoardResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    boolean existsByBoardNumber(Integer boardNumber);

    BoardEntity findByBoardNumber(Integer boardNumber);

    //Native Query를 사용해서 조인문
    @Query(value=
            "SELECT B.board_number as boardNumber, B.title AS title, B.content AS content, " +
            " B.write_datetime AS writeDatetime, B.writer_email AS writerEmail, " +
            " U.nickname AS writerNickname, U.profile_image AS writerprofileImage " +
            "FROM board AS B " +
            "INNER JOIN user AS U ON b.writer_email = U.email "+
            "WHERE board_number = ?1",

            nativeQuery=true
    )
    GetBoardResultSet getBoard(Integer boardNumber);

}
