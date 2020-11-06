package com.perifacode.gerenciador.usecase.excecao;

public class MembroExistenteException extends RuntimeException {
  public MembroExistenteException(String msg, String campo) {
    super(msg);
  }

}
