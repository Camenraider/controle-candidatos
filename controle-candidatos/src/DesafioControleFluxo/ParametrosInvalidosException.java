package DesafioControleFluxo;

import java.util.InputMismatchException;

public class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(){}
    public ParametrosInvalidosException(String mensagem){
        super(mensagem);
        System.out.println(mensagem);
    }
    public ParametrosInvalidosException(Throwable causa){
        super(causa);
    }
    public ParametrosInvalidosException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }



}
