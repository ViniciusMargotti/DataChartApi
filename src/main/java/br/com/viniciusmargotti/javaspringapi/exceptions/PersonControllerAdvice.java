package br.com.viniciusmargotti.javaspringapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler(PersonValidationErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handlerPersonValidationErrorException(PersonValidationErrorException personValidationErrorException){
        ErrorResponse errorResponse = getPersonValidationErrorExceptionResponse(personValidationErrorException, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProcessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlerPersonNotFoundExceptionResponse( ProcessException personNotFoundException ){
        ErrorResponse errorResponse = getPersonNotFoundExceptionResponse(personNotFoundException, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    private ErrorResponse getPersonValidationErrorExceptionResponse(PersonValidationErrorException personValidationErrorException,
                                                                    HttpStatus httpStatus) {
        return new ErrorResponse(
                personValidationErrorException.getMessage(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                personValidationErrorException.getClass().getSimpleName(),
                personValidationErrorException.getErrors()
        );
    }

    private ErrorResponse getPersonNotFoundExceptionResponse(ProcessException personNotFoundException,
                                                             HttpStatus httpStatus){
        return new ErrorResponse(
                personNotFoundException.getMessage(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                personNotFoundException.getClass().getSimpleName(),
                null
        );
    }
}