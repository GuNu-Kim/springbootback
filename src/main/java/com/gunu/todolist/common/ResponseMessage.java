package com.gunu.todolist.common;

public interface ResponseMessage {
    /*
        인터페이스에서는 반드시 public static final로 변수 생성해야 함
        인터페이스에서는 public static final을 지정 안해도, 모든 변수를 public static final 인식 함
     */

    //HTTP Status 200
    public static final String SUCCESS = "Success.";

    //HTTP Status 400
    String VALIDATION_FAILED = "Validation failed";
    String DUPLICATE_EMAIL = "Duplicate email";
    String DUPLICATE_NICKNAME = "Duplicate nickname";
    String DUPLICATE_TEL_NUMBER = "Duplicate tel number";
    String NOT_EXISTED_USER = "This user does not exist";
    String NOT_EXISTED_BOARD = "This board does not exist";

    //HTTP Status 401
    String SIGN_IN_FAIL = "login information mismatch";
    String AUTHORIZATION = "Authorization Failed";

    //HTTP Status 403
    String NO_PERMISSION = "Do not have permission";

    //HTTP Status 500
    String DATABASE_ERROR = "Database error";
}
