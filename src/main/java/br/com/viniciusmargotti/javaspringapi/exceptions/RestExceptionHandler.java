package br.com.viniciusmargotti.javaspringapi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException,
																  HttpHeaders httpHeaders,
																  HttpStatus httpStatus,
																  WebRequest webRequest) {

		List<ObjectError> objectErrorList = getErrors(methodArgumentNotValidException);

		ErrorResponse errorResponse = getErrorResponse(methodArgumentNotValidException, httpStatus, objectErrorList);

		return new ResponseEntity<>(errorResponse, httpStatus);
	}

	private ErrorResponse getErrorResponse(MethodArgumentNotValidException methodArgumentNotValidException,
										   HttpStatus httpStatus,
										   List<ObjectError> objectErrorList) {
		return new ErrorResponse(
				"Request has invalid fields",
				httpStatus.value(),
				httpStatus.getReasonPhrase(),
				methodArgumentNotValidException.getBindingResult().getObjectName(),
				objectErrorList
		);
	}

	private List<ObjectError> getErrors(MethodArgumentNotValidException methodArgumentNotValidException) {
		return methodArgumentNotValidException.getBindingResult().getFieldErrors().stream()
				.map(error -> new ObjectError(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
				.collect(Collectors.toList());
	}
}