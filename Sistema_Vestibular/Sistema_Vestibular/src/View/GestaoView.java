package View;

import java.io.IOException;
import java.util.Scanner;
import Controller.ManipuladorArquivoController;
import Controller.ListaCandidatosController;
import View.CampusInscritoView;
import View.InscricaoView;

public class GestaoView {
    public void menuGestao() throws IOException {
        ManipuladorArquivoController mp = new ManipuladorArquivoController();
        CampusGestaoView campusGestao = new CampusGestaoView();
        CampusInscritoView campusInscrito = new CampusInscritoView();
        ListaCandidatosController listaCandidatos = new ListaCandidatosController();
        listaCandidatos = mp.lerCandidatos();
        Scanner ler = new Scanner(System.in);
        System.out.println("***********************************************************************\n"
                + "Olá, seja bem-vindo a área de gestão de Candidatos.!!\n"
                + "***********************************************************************");
        String candidatos = null;
        int opc = 0;
        while (opc != 9) {
            System.out.println("Digite o número de uma das opções abaixo: \n" + "1- Visualizar inscritos. \n"
                    + "2- Ordenar inscritos por nome.\n" + "3- Gerir campus. \n" + "4- Visualizar campus.\n" + "9- Voltar ao inicio.");

            opc = ler.nextInt();
            switch (opc) {
                case 1:
                    candidatos = listaCandidatos.percorre();
                    System.out.println("***********************************************************************\n");
                    System.out.println(candidatos);
                    System.out.println("***********************************************************************\n");
                    break;
                case 2:
                    listaCandidatos = listaCandidatos.ordenarPorNome();
                    candidatos = listaCandidatos.percorre();
                    System.out.println("***********************************************************************\n");
                    System.out.println(candidatos);
                    System.out.println("***********************************************************************\n");
                    break;
                case 3:
                    campusGestao.menuCampus();
                    break;
                case 4: 
                    campusInscrito.menuCampusIncrito();
                case 9:
                    break;
                default:
                    System.out.println("DIGITE UMA OPÇÃO VÁLIDA!");

            }
        }
    }
}