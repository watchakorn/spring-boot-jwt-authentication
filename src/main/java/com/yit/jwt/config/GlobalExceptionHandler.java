package com.yit.jwt.config;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> SQLException(SQLException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        String message = ex.getMessage();
        if (message.toLowerCase().indexOf("duplicate") > 0) {
            message = "Duplication data";
            body.put("timestamp", LocalDateTime.now());
            body.put("message", message);
            body.put("path", request.getDescription(false));

            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }

        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        body.put("path", request.getDescription(false));

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleGlobalException(
//            Exception ex, WebRequest request) {
//
//        Map<String, Object> body = new HashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("message", "An unexpected error occurred: " + ex.getMessage());
//        body.put("path", request.getDescription(false));
//
//        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
