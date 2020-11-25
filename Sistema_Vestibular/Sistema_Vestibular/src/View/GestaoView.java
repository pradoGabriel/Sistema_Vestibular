package View;

import java.util.Scanner;
import Controller.ManipuladorArquivoController;
import Model.CandidatoModel;
import Controller.ListaCandidatosController;
import Controller.ListaSituacaoController;
import View.CampusInscritoView;
import View.InscricaoView;

public class GestaoView {
    public void menuGestao() throws Exception {
        ManipuladorArquivoController mp = new ManipuladorArquivoController();
        CampusGestaoView campusGestao = new CampusGestaoView();
        CampusInscritoView campusInscrito = new CampusInscritoView();
        AnaliseCandidatoView situacao  = new AnaliseCandidatoView();
        CursoGestaoView cursoGestao = new CursoGestaoView();
        ListaCandidatosController listaCandidatos = new ListaCandidatosController();
        listaCandidatos = mp.lerCandidatos();
        ListaSituacaoController listaSituacao = new ListaSituacaoController();
        
        Scanner ler = new Scanner(System.in);
        System.out.println("***********************************************************************\n"
                + "OlÃ¡, seja bem-vindo a Ã¡rea de gestÃ£o de Candidatos.!!\n"
                + "***********************************************************************");
        String candidatos = null;
        int opc = 0;
        while (opc != 9) {
            System.out.println("Digite o numero de uma das alternativas abaixo: \n"
                    + "1- Visualizar inscritos. \n"
                    + "2- Ordenar inscritos por nome.\n"
                    + "3- Gerir campus. \n"
                    + "4- Visualizar campus.\n"
                    + "5- Gerir cursos.\n"
                    + "6- Analisar Candidatos.\n"
                    + "7- Visualizar Candidatos Analisados.\n"
                    + "9- Voltar ao inicio.");

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
                case 5:
                    cursoGestao.menuCursoGestao();
                    break;
                case 6:
                	situacao.escolhaCandidato(listaCandidatos);
                    break;
                case 7:
                	listaSituacao = mp.lerSituacao();
                	listaSituacao = listaSituacao.ordenarPorNome();
                	System.out.println(listaSituacao.percorre());
                    break;
                case 9:
                    break;
                default:
                    System.out.println("DIGITE UMA ALTERNATIVA VALIDA!");

            }
        }
    }
}