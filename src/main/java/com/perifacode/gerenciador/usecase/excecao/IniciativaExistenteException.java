package com.perifacode.gerenciador.usecase.excecao;

public class IniciativaExistenteException extends RuntimeException {

    public IniciativaExistenteException(String message) {
        super(message);
    }
}
