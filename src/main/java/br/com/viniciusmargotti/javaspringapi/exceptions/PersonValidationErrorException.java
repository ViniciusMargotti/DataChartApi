package br.com.viniciusmargotti.javaspringapi.exceptions;

import java.util.List;

public class PersonValidationErrorException extends RuntimeException{

    List<ObjectError> errors;

    public PersonValidationErrorException(List<ObjectError> errors){
        super("Request has invalid fields");
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }
}