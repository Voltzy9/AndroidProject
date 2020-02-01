package com.myapp.arthurgenthial.network;

import retrofit2.Response;
import java.io.IOException;


public class ApiError {
    public String code;
    public String message;

    public ApiError(Response response) {
        this.code = String.valueOf(response.code());
        try {
            this.message = response.errorBody().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ApiError(Throwable throwable) {
        this.code = "EXC";
        this.message = throwable.getMessage();
    }
}
