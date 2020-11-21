package Controller;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;

public class ManipuladorArquivoController {

	public void gravar(String linha, String path) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
		bw.append(linha + "\n");
		bw.close();
		System.out.println("Registro gravado com sucesso!");
	}

	public ListaCandidatosController lerCandidatos() throws IOException {
		ListaCandidatosController lista = new ListaCandidatosController();
		BufferedReader bf = new BufferedReader(new FileReader("candidatos.txt"));
		String linha = null;
		while (true) {
			linha = bf.readLine();
			if (linha != null) {
				String array[] = new String[6];
				array = linha.split(";");
				lista.adicionaFinal(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
			} else {
				break;
			}
		}
		bf.close();

		return lista;
	}

	// Realiza grava�ao em um Arquivo TXT
	public void gravaCampus(int conta, String[] vet) throws IOException {
		int i;
		String fileName = "campus.txt";
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
		for (i = 0; i < conta; i++) {
			gravar.write(vet[i]);
			gravar.newLine();
		}
		System.out.println("Arquivo Gerado");
		gravar.close();
	}

	// Realiza a Leitura dos elementos no Arquivo TXT
	public void lerCampus(ListaCampusController campus2) throws IOException {
		String fileName = "campus.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		String j = "";
		while (j != null) {
			String r = (ler.readLine());
			j = r;
			if (j != null) {
				campus2.AdicionaCampusFinal(r);
			}
		}
		ler.close();
	}
}
