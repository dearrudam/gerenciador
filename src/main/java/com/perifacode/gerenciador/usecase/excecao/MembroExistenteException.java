package com.perifacode.gerenciador.usecase.excecao;

public class MembroExistenteException extends RuntimeException {
  public MembroExistenteException() {
    super("Já existe um membro com este e-mail!");
  }

}
