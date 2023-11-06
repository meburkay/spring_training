package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

//We create this class for giving custom information in the response body. We add fields according to our needs and Object data for the real data body. We create two constructors one with data and one without. For the operations that do not response data like delete etc. we will use without data constructor for the other we use with data constructor.
@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data){
        this.message = message;
        this.data=data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message){
        this.message=message;
        this.code=HttpStatus.OK.value();
        this.success=true;
    }

}
