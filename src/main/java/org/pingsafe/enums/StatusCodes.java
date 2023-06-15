package org.pingsafe.enums;

public enum StatusCodes {

     CODE_200(200,""),
     CODE_403(403,"Unauthorized"),
     CODE_400(400,"Bad Request"),
     CODE_500(500,"Internal Server Error");


    public final int code;
    public final String message;

    StatusCodes (int code , String message){
        this.code = code;
        this.message=message;
    }
}
