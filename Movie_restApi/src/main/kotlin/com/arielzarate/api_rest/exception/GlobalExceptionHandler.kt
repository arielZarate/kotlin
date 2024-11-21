package com.arielzarate.api_rest.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler {


    @ExceptionHandler(IllegalArgumentException ::class)
    fun handlerBadRequestException(e:IllegalArgumentException):ResponseEntity<String>{
        return ResponseEntity(e.message,HttpStatus.BAD_REQUEST)
    }


    // Manejar todas las demás excepciones
    @ExceptionHandler(Exception::class)
    fun handleInternalServerError(e: Exception): ResponseEntity<String> {
        return ResponseEntity("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR)
    }


    @ExceptionHandler(MovieException:: class)
    fun movieExceptionHandler(exception: MovieException):ResponseEntity<String>{

        return ResponseEntity(exception.message,HttpStatus.BAD_REQUEST);
    }


}