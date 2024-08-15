package DesafioControleFluxo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        int parametroUm = 0;
        int parametroDois = 0;
        Scanner terminal = new Scanner(System.in);

        // tratamento de erros não inteiros.
        try {
            System.out.println("Digite o primeiro parâmetro");
            parametroUm = terminal.nextInt();
            System.out.println("Digite o segundo parâmetro");
            parametroDois = terminal.nextInt();
            terminal.close();
        } catch (InputMismatchException e) {
            System.out.println("Os parâmetros devem ser numeros inteiros");
        }

        // tratamento da lógica de contagem.
        try {
            //chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);

        }catch (ParametrosInvalidosException e) {
            //imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }

    }
    static void contar(Integer parametroUm, Integer parametroDois ) throws ParametrosInvalidosException {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois){
            throw new ParametrosInvalidosException("Falha, erro na entrada dos parâmetros.");
        }

        int contagem = parametroDois - parametroUm;
        System.out.println("Imprimindo de 1 até " + contagem);
        //realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++){
            System.out.println("Imprimindo o número " + i);
        }
    }

}
