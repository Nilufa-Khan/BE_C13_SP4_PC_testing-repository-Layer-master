package com.example.demopc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "customer id is not found which is given by you")
public class ClassNotFound extends Exception{
}
