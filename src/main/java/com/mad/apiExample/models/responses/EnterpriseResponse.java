package com.mad.apiExample.models.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Kuldeep Dangi <kuldeepamy@gmail.com>
 */
@Setter
@Getter
public class EnterpriseResponse<T> {

    private Integer code;
    private boolean success;
    private String message;
    private T data;

    public EnterpriseResponse(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public EnterpriseResponse(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static ResponseEntity<EnterpriseResponse> success(String message) {
        EnterpriseResponse response = new EnterpriseResponse<>(true, HttpStatus.OK.value(), message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<EnterpriseResponse> success(String message, T data) {
        EnterpriseResponse response = new EnterpriseResponse(true, HttpStatus.OK.value(), message, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public static ResponseEntity<EnterpriseResponse> failed(HttpStatus code, String message) {
        EnterpriseResponse response = new EnterpriseResponse<>(false, code.value(), message);
        return new ResponseEntity<>(response, code);
    }

    public static <T> ResponseEntity<EnterpriseResponse> failed(HttpStatus code, String message, T data) {
        EnterpriseResponse response = new EnterpriseResponse(false, code.value(), message, data);
        return new ResponseEntity<>(response, code);
    }

}
