package Controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import Controller.ListaCandidatosController;

public class ManipuladorArquivoController {
	
	ListaCandidatosController candidatos = new ListaCandidatosController();
	
	public void gravarInscricao(String nome, String rg, int cpf, int idade, String nomeDoCurso, int periodo)
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("candidatos.txt"));
		String linha = nome + ";" + rg + ";" + cpf + ";" + idade + ";" + nomeDoCurso + ";" + periodo;
		bw.append(linha + "\n");
		bw.close();
	}

	public void lerInscricao () throws IOException {
		BufferedReader bf = new BufferedReader (new FileReader ("candidatos.txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
				String array[] = new String[6];
				array = linha.split(";");
				candidatos.adicionaFinal(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));		
			} else 
				break;
			linha = bf.readLine();
		}
		bf.close();
	}
}
