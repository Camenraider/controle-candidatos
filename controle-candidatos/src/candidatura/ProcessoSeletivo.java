package candidatura;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela",
                "Daniela", "Jorge"};


        System.out.println("\n----------------Seletiva-----------------------");
        ArrayList selecionados = selecaoCandidatos(candidatos);
        System.out.println("\n----------------Imprimindo---------------------");
        imprimirSelecionados(selecionados);


        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }

//        analisarCandidato(1900.0);

//        selecaoCandidatos(cadidatos);
//        imprimirSelecionados(candidatos);

    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }

        } while(continuarTentando && tentativasRealizadas < 3);

        if (atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + " número máximo de tentativas " + tentativasRealizadas + " tentativa");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados(ArrayList candidatos){

        System.out.println("\nImprimindo candidatos informando o indice do elemento\n");
        for(int indice =0; indice < candidatos.size(); indice++) {
            System.out.println("O candidato de n° " + (indice + 1) + " é " + candidatos.get(indice));
        }
        System.out.println("\nForma abreviada de interação for each\n");
        for (Object candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static ArrayList selecaoCandidatos(String[] candidatos) {
        ArrayList candidatosEscolhidos = new ArrayList<String>();
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosEscolhidos.add(candidato);
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
       return candidatosEscolhidos;
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if (salarioBase  > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        }
        else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
