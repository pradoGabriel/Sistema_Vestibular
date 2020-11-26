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
	    aux = percorreAvaliados(listaCandidatos, listaSituacao);
	    
	    
	    System.out.println("***********************************************************************\n"
	            + "Lista de Candidatos a serem analisados.!!\n"
	            + "***********************************************************************");
	  	       
	    for(int i=0;i<aux.length;i++){
	    	if(aux[i]!=null)
	    	System.out.println(i+1+"- "+aux[i]);
	    }
	    
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
	    ler.nextLine();
	    System.out.println("Detalhe o motivo");
	    String detalhes = ler.nextLine();
	    String curso  = "curso";
	    String linha = candidato.getNome()+";"+candidato.getCpf()+";"+opt+";"+curso+";"+detalhes;    
	    mp.gravar(linha, "situacao.txt");
	}
	
	private CandidatoModel[] percorreAvaliados(ListaCandidatosController listaCandidatos, ListaSituacaoController listaSituacao) {
		CandidatoModel[] aux = new CandidatoModel[listaCandidatos.tamanho()];
	    aux=listaCandidatos.toVet();
	    SituacaoModel[] aux2 = new SituacaoModel[listaSituacao.tamanho()];
	    aux2=listaSituacao.toVet();
	    CandidatoModel[] candidatos = new CandidatoModel[listaCandidatos.tamanho()];
	    boolean valido=true;
	    int contador=1;
	    for(int i=0;i<aux.length;i++){
	    	for(int j=0;j<aux2.length;j++){
	    		if(aux[i].getCpf().equals(aux2[j].getCpf())){
	    			valido=false;
	    		}
	    	}
	    	if(valido==true){
	    		candidatos[contador-1] = aux[i];
	    		contador++;
	    	}
	    	valido = true;
	    }
	    return candidatos;
	}
	
}
