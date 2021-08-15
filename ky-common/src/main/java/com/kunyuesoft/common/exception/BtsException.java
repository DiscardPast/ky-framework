package com.kunyuesoft.common.exception;

import com.kunyuesoft.common.enums.ResultEnum;
import lombok.Data;

@Data
public class BtsException extends RuntimeException {

    private String code;

    public BtsException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BtsException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
