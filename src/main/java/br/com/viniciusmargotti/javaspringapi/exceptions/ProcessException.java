package br.com.viniciusmargotti.javaspringapi.exceptions;

public class ProcessException extends RuntimeException{

    public ProcessException(String message){
        super(message);
    }

}