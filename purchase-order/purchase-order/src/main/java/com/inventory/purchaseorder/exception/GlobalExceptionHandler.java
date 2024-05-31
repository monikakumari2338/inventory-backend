package com.inventory.purchaseorder.exception;

import java.net.http.HttpHeaders;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.inventory.purchaseorder.exception.ExceptionHandling;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	

	@ExceptionHandler(ExceptionHandling.class)
	public ResponseEntity<ErrorDetails> handleBlogAPIException(ExceptionHandling exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// global exceptions
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest) {
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
//				webRequest.getDescription(false));
//		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String message = error.getDefaultMessage();
//			errors.put(fieldName, message);
//		});
//
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
//
////    @ExceptionHandler(MethodArgumentNotValidException.class)
////    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
////                                                                        WebRequest webRequest){
////        Map<String, String> errors = new HashMap<>();
////        exception.getBindingResult().getAllErrors().forEach((error) ->{
////            String fieldName = ((FieldError)error).getField();
////            String message = error.getDefaultMessage();
////            errors.put(fieldName, message);
////        });
////        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
////    }
//
//	@ExceptionHandler(AccessDeniedException.class)
//	public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException exception,
//			WebRequest webRequest) {
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
//				webRequest.getDescription(false));
//		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
//	}
}