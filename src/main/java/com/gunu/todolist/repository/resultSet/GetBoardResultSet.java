package com.gunu.todolist.repository.resultSet;

public interface GetBoardResultSet {

    Integer getBoardNumber();
    String getTitle();
    String getContent();
    String getWriteDatetime();
    String getwriterEmail();
    String getwriterNickname();
    String getwriterprofileImage();
}
