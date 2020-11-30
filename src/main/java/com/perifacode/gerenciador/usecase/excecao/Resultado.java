package com.perifacode.gerenciador.usecase.excecao;

import com.perifacode.gerenciador.adapter.presenters.TipoIniciativaDto;

public class Resultado<R, Ex> {

  private R result;
  private Ex exception;
  private boolean sucess = false;

  public Resultado<R, Ex> falha(
      Ex ex) {
    Resultado r = new Resultado<>();
    r.sucess = false;
    r.exception = ex;
    return r;
  }

  public Resultado<R, Ex> sucesso(R result) {
    Resultado r = new Resultado<>();
    r.sucess = true;
    r.result = result;
    return r;
  }

  public boolean isSucess(){
    return sucess;
  }

  public R getResult(){
    return result;
  }

}
