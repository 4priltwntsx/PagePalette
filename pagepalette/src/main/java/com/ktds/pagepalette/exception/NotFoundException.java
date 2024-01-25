package com.ktds.pagepalette.exception;


import java.io.Serial;

public class NotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("해당 정보를 찾을 수 없습니다.");
    }

    public NotFoundException(String msg) {
        super(msg);
    }
}