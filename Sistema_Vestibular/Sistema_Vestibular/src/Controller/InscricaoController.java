package Controller;

import java.io.IOException;
import java.util.Scanner;
import Controller.ManipuladorArquivoController;

public class InscricaoController {

	private String nome;
	private String rg;
	private int cpf;
	private int idade;
	private String nomeDoCurso;
	private int periodo;
	private int quantidadeSemestres;
	private int vagas;

	public void gravarInscricao() throws IOException {
		System.out.println("************************************************************/n"
				+ "          Seja bem-vindo(a) a área de inscrição             /n"
				+ "          Vamos precisar de algumas informações             /n"
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
		System.out.println("Curso: ");
		nomeDoCurso = ler.nextLine();
		System.out.println("Período (1-Manhã 2-Tarde 3-Noite: ");
		periodo = ler.nextInt();

		ManipuladorArquivoController mp = new ManipuladorArquivoController();
		mp.gravarInscricao(nome, rg, cpf, idade, nomeDoCurso, periodo);
	}

}
