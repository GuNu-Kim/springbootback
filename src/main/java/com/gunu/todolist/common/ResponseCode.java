package com.gunu.todolist.common;

public interface ResponseCode {
    /*
        인터페이스에서는 반드시 public static final로 변수 생성해야 함
        인터페이스에서는 public static final을 지정 안해도, 모든 변수를 public static final 인식 함
     */

    //HTTP Status 200
    public static final String SUCCESS = "SU";

    //HTTP Status 400
    String VALIDATION_FAILED = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXISTED_USER = "NU";
    String NOT_EXISTED_BOARD = "NB";

    //HTTP Status 401
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION = "AF";

    //HTTP Status 403
    String NO_PERMISSION = "NP";

    //HTTP Status 500
    String DATABASE_ERROR = "DBE";
}
