package com.perifacode.gerenciador.usecase.excecao;

public class Resultado<R, E> {

  private R result;
  private E exception;
  private boolean sucess = false;

  public Resultado<R, E> falha(
      E ex) {
    Resultado r = new Resultado<>();
    r.sucess = false;
    r.exception = ex;
    return r;
  }

  public Resultado<R, E> sucesso(R result) {
    Resultado r = new Resultado<>();
    r.sucess = true;
    r.result = result;
    return r;
  }

  public boolean isSucess() {
    return sucess;
  }

  public R getResult() {
    return result;
  }

}
