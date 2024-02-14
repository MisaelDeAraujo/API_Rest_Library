package git.misaeldearaujo.library.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import git.misaeldearaujo.library.exception.FullBookException;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(FullBookException.class)
	public ResponseEntity<String> fullBookExcpetion(FullBookException fullBookException){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Excedeu Limite de Caracteres");
	}
	

}
