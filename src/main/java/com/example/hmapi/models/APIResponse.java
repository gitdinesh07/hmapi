package com.example.hmapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class APIResponse<T> {

    private boolean success;
    private T data;
    private String message;

    public static<T> APIResponse<T> Success(T data, String message)
    {
        return new APIResponse<T>(true,data,message);
    }

    public static<T> APIResponse<T> Success(T data)
    {
        return new APIResponse<T>(true,data,null);
    }

    public static<T> APIResponse<T> Fail(String message)
    {
        return new APIResponse<T>(false,null, message);
    }
}
