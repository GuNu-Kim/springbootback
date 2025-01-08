package com.gunu.todolist.repository;

import com.gunu.todolist.entity.FavoriteEntity;
import com.gunu.todolist.entity.primaryKey.FavoritePk;
import com.gunu.todolist.repository.resultSet.GetFavoriteListResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {

    FavoriteEntity findByBoardNumberAndUserEmail(Integer boardNumber, String userEmail);

    @Query(value = "" +
            "SELECT U.email AS email, " +
            " U.nickname AS nickname, " +
            " U.profile_image AS profileImage " +
            "FROM favorite AS F " +
            "INNER JOIN user as U " +
            "ON f.board_Number= ?1 ",

            nativeQuery = true
    )
    List<GetFavoriteListResultSet> getFavoriteList(Integer boardNumber);
}
