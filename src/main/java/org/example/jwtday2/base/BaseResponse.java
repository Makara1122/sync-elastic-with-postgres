package org.example.jwtday2.base;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Data
@Accessors(chain = true)
public class BaseResponse<T> {

    private T payload;
    private String message;
    private Object metadata; // relates to pagination
    private int status;

    public static <T>BaseResponse<T> createSuccess() {
        return new BaseResponse<T>().setStatus(HttpStatus.CREATED.value()).setMessage("Create Success");
    }
    public static <T>BaseResponse<T> notFount() {
        return new BaseResponse<T>().setStatus(HttpStatus.NO_CONTENT.value()).setMessage("Not Found");
    }
    public static <T>BaseResponse<T> ok() {
        return new BaseResponse<T>().setStatus(HttpStatus.OK.value()).setMessage("Get all Success");
    }
    public static <T>BaseResponse<T> upDateSuccess() {
        return new BaseResponse<T>().setStatus(HttpStatus.CREATED.value()).setMessage("Update Success");
    }

    public static <T>BaseResponse<T> badRequest(){
        return new BaseResponse<T>().setStatus(HttpStatus.BAD_REQUEST.value()).setMessage("Bad Request");
    }

}
