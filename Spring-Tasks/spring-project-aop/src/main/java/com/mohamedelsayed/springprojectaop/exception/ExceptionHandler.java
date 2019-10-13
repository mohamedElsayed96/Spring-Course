package com.mohamedelsayed.springprojectaop.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ExceptionHandler extends RuntimeException {

private static final long serialVersionUID = 1L;

////system defined exceptions
public ResponseEntity<?> throwExeption(HttpStatus status)
{
	return ResponseEntity.status(status).build();
}

public ResponseEntity<?> throwExeption(HttpStatus status,String msg)
{
	return ResponseEntity.status(status).body(msg);
}

public ResponseEntity<?> throwExeption(HttpStatus status,Exception exception)
{
	return ResponseEntity.status(status).body(exception);
}
////user int Exceptions
public ResponseEntity<?> throwExeption(int status,String msg)
{
	return ResponseEntity.status(status).body(msg);
}

public ResponseEntity<?> throwExeption(int status,Exception exception)
{
	return ResponseEntity.status(status).body(exception);
}

////enum defind exceptions
public ResponseEntity<?> throwExeption(ExceptionEnum status)
{
	return ResponseEntity.status(status.getValue()).build();
}

public ResponseEntity<?> throwExeption(ExceptionEnum status,Exception exception)
{
	return ResponseEntity.status(status.getValue()).body(exception);
}

public ResponseEntity<?> throwExeption(ExceptionEnum status,String msg)
{
	return ResponseEntity.status(status.getValue()).body(msg);
}



}
