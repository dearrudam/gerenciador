package com.perifacode.gerenciador.usecase.excecao;

public class MembroInexistenteException extends RuntimeException {
  public MembroInexistenteException(String msg) {
    super(msg);
  }
}
