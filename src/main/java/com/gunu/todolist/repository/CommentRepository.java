package com.gunu.todolist.repository;

import com.gunu.todolist.entity.CommentEntity;
import com.gunu.todolist.repository.resultSet.GetCommentListResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    @Query(value="" +
            "SELECT U.nickname AS nickname," +
            " U.profile_image AS profileImage, " +
            " C.write_datetime AS writeDatetime, " +
            " C.content AS content " +
            "FROM comment AS C " +
            "INNER JOIN user AS U " +
            "ON C.user_email = U.email " +
            "WHERE c.board_number = ?1 " +
            "ORDER BY writeDatetime DESC ",
            nativeQuery=true)

    List<GetCommentListResultSet> getCommentList(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
