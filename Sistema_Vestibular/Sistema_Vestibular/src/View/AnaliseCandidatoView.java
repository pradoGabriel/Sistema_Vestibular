package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.ListaCandidatosController;
import Controller.ListaSituacaoController;
import Controller.ManipuladorArquivoController;
import Model.CandidatoModel;
import Model.SituacaoModel;

public class AnaliseCandidatoView {
		
	public void escolhaCandidato(ListaCandidatosController listaCandidatos) throws IOException{
		ManipuladorArquivoController mp = new ManipuladorArquivoController();
	    Scanner ler = new Scanner(System.in);
	    listaCandidatos = listaCandidatos.ordenarPorNome();
	    ListaSituacaoController listaSituacao = new ListaSituacaoController();
	    listaSituacao = mp.lerSituacao();
	    CandidatoModel[] aux = new CandidatoModel[listaCandidatos.tamanho()];
	    aux=listaCandidatos.toVet();
	    
	    System.out.println("***********************************************************************\n"
	            + "Lista de Candidatos a serem analisados.!!\n"
	            + "***********************************************************************");
	  	   
	    String mostrar = listaCandidatos.percorre();
	    System.out.println(mostrar);
	    
	    System.out.print("Escolha o candidato a ser analisado: ");
	    int opt = ler.nextInt()-1;
	 	menuAnalise(aux[opt]);
		
	}

	public void menuAnalise(CandidatoModel candidato) throws IOException{
		ManipuladorArquivoController mp = new ManipuladorArquivoController();   
	 
	    Scanner ler = new Scanner(System.in);
	    System.out.println("***********************************************************************\n"
	            + "Candidato a ser analisado.!!\n"
	            + "***********************************************************************");
	    
	    System.out.println(candidato.toString());
	    System.out.println("*********************************************************************");
	    System.out.println("Opções:\n1 - Aprovado\n2 - Reprovado");
	    int opt = ler.nextInt();
	    System.out.println("Detalhe o motivo");
	    String detalhes = ler.next();
	    String curso  = "curso";
	    String linha = candidato.getNome()+";"+candidato.getCpf()+";"+opt+";"+curso+";"+detalhes;    
	    mp.gravar(linha, "situacao.txt");
	    
	}
	
}
