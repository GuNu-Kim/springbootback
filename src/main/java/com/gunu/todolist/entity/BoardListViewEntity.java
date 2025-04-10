package com.gunu.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board_list_view")
@Table(name = "board_list_view")
public class BoardListViewEntity {

    @Id
    private int boardNumber;
    private int commentCount;
    private String content;
    private int favoriteCount;
    private String title;
    private String titleImage;
    private int viewCount;
    private String writeDateTime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;
}
