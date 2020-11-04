package com.perifacode.gerenciador.adapter.controller;

import com.perifacode.gerenciador.usecase.excecao.MembroExistenteException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(
      value = {DataIntegrityViolationException.class})
  protected ResponseEntity<Object> handleConflict(
      DataIntegrityViolationException ex, WebRequest request) {
    String bodyOfResponse = "Falha ao efetuar a requisição, conflito " + ex.getMessage();
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.CONFLICT, request);
  }

  @ExceptionHandler(
      value = {MembroExistenteException.class})
  protected ResponseEntity<Object> notFound(
      MembroExistenteException ex, WebRequest request) {
    String bodyOfResponse = ex.getMessage();
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }


}
