package View;

import java.util.Arrays;
import java.util.Scanner;
import Controller.ManipuladorArquivoController;
import Model.CursoModel;
import Controller.ListaCandidatosController;
import Controller.ListaCursosController;

public class CursoGestaoView {
    private String nomeDoCurso;
    private int periodo;
    private int quantidadeSemestres;
    private int vagas;

    public void menuCursoGestao() throws Exception {
        ListaCursosController listaCursos = new ListaCursosController();
        ListaCandidatosController listacandid = new ListaCandidatosController();
        ManipuladorArquivoController manipArqContr = new ManipuladorArquivoController();
        listaCursos = manipArqContr.lerCursos();
        Scanner ler = new Scanner(System.in);
        System.out.println("***********************************************************************\n"
                + "Olá, seja bem-vindo a área de gestão de Cursos.!!\n"
                + "***********************************************************************");

        int opcao = 0;
        while (opcao != 11) {
            System.out.println("....................................................................\n"
                    + "\nDigite o número para acessar uma das opções citadas: \n"
                    + " 1- Adicionar um novo curso em qualquer posicao;\n"
                    + " 2- Adicionar um novo curso no inicio;\n"
                    + " 3- Adicionar um novo curso no fim;\n"
                    + " 4- Remover um curso em qualquer posicao;\n"
                    + " 5- Remover um curso no inicio;\n"
                    + " 6- Remover um curso no fim;\n"
                    + " 7- Exibir lista de cursos;\n"
                    + " 8- Buscar um curso;\n"
                    + " 9- Verificar quantidade de cursos registrados;\n"
                    + "10- Ordenar a lista de cursos em ordem alfabética;\n"
                    + "11- Voltar ao menu de gestao;\n"
                    + "....................................................................");

            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    int posicao;
                    System.out.println("<==========================================================>");
                    System.out.println("PREENCHA OS CAMPOS CITADOS:\nPosicao a ser adicionada:");
                    posicao = ler.nextInt();
                    obterInputCurso();
                    System.out.println("<==========================================================>");
                    listaCursos.adicionaNaPosicao(nomeDoCurso, periodo, quantidadeSemestres, vagas, posicao);
                    manipArqContr.gravaCursos(listaCursos);
                    break;
                case 2:
                    System.out.println("<==========================================================>");
                    System.out.println("PREENCHA OS CAMPOS CITADOS:\n");
                    obterInputCurso();
                    System.out.println("<==========================================================>");
                    listaCursos.adicionaInicio(nomeDoCurso, periodo, quantidadeSemestres, vagas);
                    manipArqContr.gravaCursos(listaCursos);
                    break;
                case 3:
                    System.out.println("<==========================================================>");
                    System.out.println("PREENCHA OS CAMPOS CITADOS:\n");
                    obterInputCurso();
                    System.out.println("<==========================================================>");
                    listaCursos.adicionaFinal(nomeDoCurso, periodo, quantidadeSemestres, vagas);
                    manipArqContr.gravaCursos(listaCursos);
                    break;
                case 4:
                    System.out.println("<==========================================================>");
                    System.out.println("PREENCHA OS CAMPOS CITADOS:\nLista dos cursos:");
                    listaCursos.exibeLista();
                    System.out.println("\nEscreva o nome do curso a ser removido:");
                    listaCursos.removeCurso(ler.nextLine());
                    System.out.println("<==========================================================>");
                    manipArqContr.gravaCursos(listaCursos);
                    break;
                case 5:
                    listaCursos.removeInicio();
                    manipArqContr.gravaCursos(listaCursos);
                    break;
                case 6:
                    listaCursos.removeFinal();
                    manipArqContr.gravaCursos(listaCursos);
                    break;
                case 7:
                    System.out.println("<==========================================================>");
                    listaCursos.exibeLista();
                    System.out.println("<==========================================================>");
                    break;
                case 8:
                Scanner scan = new Scanner(System.in);
                System.out.println("<==========================================================>");
                System.out.print("\nEscreva o nome do curso a ser buscado:\n");
                CursoModel cm = listaCursos.buscaCurso(scan.nextLine());
                System.out.print("\nCurso encontrado!\nDADOS:\nNome do curso:"+ cm.getNomeDoCurso()+ "\nPeriodo: "+ cm.getPeriodo()+ "\nQuantidade de semestres: "+ cm.getQuantidadeSemestres()+ "\nVagas: "+ cm.getVagas());
                System.out.println("<==========================================================>");
                    break;
                case 9:
                    System.out.println("A quantidade de cursos registrados atualmente é de: "+ listaCursos.getTamanho());
                    break;
                case 10:
                    listaCursos = listaCursos.ordenarPorNomeCresc();
                    System.out.println("<==========================================================>");
                    listaCursos.exibeLista();
                    System.out.println("<==========================================================>");
                    manipArqContr.gravaCursos(listaCursos);
                    break;
                case 11:
                    break;
                default:
                    System.out.println("OPÇÃO INEXISTENTE!");
            }
        }
    }

    private String obterInputCurso() {
        String dados = null;
        Scanner ler = new Scanner(System.in);
        System.out.println("Nome do curso:");
        nomeDoCurso = ler.nextLine();
        dados = nomeDoCurso;
        System.out.println("\nPeriodo (int):");
        periodo = ler.nextInt();
        dados = dados + ";" + periodo;
        System.out.println("\nQuantidade de semestres (int):");
        quantidadeSemestres = ler.nextInt();
        dados = dados + ";" + quantidadeSemestres;
        System.out.println("\nQuantidade de vagas (int):");
        vagas = ler.nextInt();
        dados = dados + ";" + vagas;
        return dados;
    }
}