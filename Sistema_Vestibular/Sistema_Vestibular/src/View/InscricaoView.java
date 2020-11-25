package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.ManipuladorArquivoController;

public class InscricaoView {

	private String nome;
	private String rg;
	private int cpf;
	private int idade;
	private String nomeCampus;
	private String nomeDoCurso;
	private int periodo;
	
	
	public void gravarInscricao() throws IOException {
		CampusInscritoView campusInscrito = new CampusInscritoView();
		System.out.println("************************************************************\n"
				+ "         Seja bem-vindo(a) a área de inscrição!             \n"
				+ "         Vamos precisar de algumas informações!             \n"
				+ "************************************************************");
		// Recebendo dados do Candidato
		Scanner ler = new Scanner(System.in);
		System.out.println("Nome completo: ");
		nome = ler.nextLine();
		System.out.println("RG: ");
		rg = ler.nextLine();
		System.out.println("CPF: ");
		cpf = ler.nextInt();
		System.out.println("Idade: ");
		idade = ler.nextInt();
		campusInscrito.menuCampusIncrito();
		System.out.println("Fim <---------> ");
		System.out.println("Campus: ");
		nomeCampus = ler.next();
		System.out.println("Curso: ");
		nomeDoCurso = ler.next();
		System.out.println("Per�odo (1-Manh� 2-Tarde 3-Noite: ");
		periodo = ler.nextInt();

		String linha = nome + ";" + rg + ";" + cpf + ";" + idade + ";"+ nomeCampus +";"+ nomeDoCurso + ";" + periodo;

		ManipuladorArquivoController mp = new ManipuladorArquivoController();
		mp.gravar(linha, "candidatos.txt");
	}
}
