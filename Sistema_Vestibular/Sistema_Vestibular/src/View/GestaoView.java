package View;

import java.io.IOException;
import java.util.Scanner;
import Controller.ManipuladorArquivoController;
import Controller.ListaCandidatosController;

public class GestaoView {
    public void menuGestao() throws IOException {
        ManipuladorArquivoController mp = new ManipuladorArquivoController();

        ListaCandidatosController listaCandidatos = new ListaCandidatosController();
        listaCandidatos = mp.lerCandidatos();
        Scanner ler = new Scanner(System.in);
        System.out.println("***********************************************************************\n"
                + "Olá, seja bem-vindo a área de gestão de Candidatos.!!\n"
                + "***********************************************************************");

        int opc = 0;
        while (opc != 9) {
            System.out.println("Digite o número de uma das opções abaixo: \n" + "1- Visualizar inscritos. \n"
                    + "2- Ordenar inscritos por nome.\n" + "9- Voltar ao inicio.");

            opc = ler.nextInt();
            switch (opc) {
                case 1:
                    String candidatos = null;
                    candidatos = listaCandidatos.percorre();
                    System.out.println(candidatos);
                    break;
                case 2:
                    listaCandidatos.ordenarPorNome();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("DIGITE UMA OPÇÃO VÁLIDA!");

            }
        }
    }
}