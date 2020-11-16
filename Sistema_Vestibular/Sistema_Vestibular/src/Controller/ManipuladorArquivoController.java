package Controller;

import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;

public class ManipuladorArquivoController {

	public void gravar(String linha, String path) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.append(linha + "\n");
		bw.close();
	}

	public ListaCandidatosController lerCandidatos() throws IOException {
		ListaCandidatosController lista = new ListaCandidatosController();
		BufferedReader bf = new BufferedReader(new FileReader("candidatos.txt"));
		String linha = null;
		while (true) {
			if (linha != null) {
				String array[] = new String[6];
				array = linha.split(";");
				lista.adicionaFinal(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
			} else {
				System.out.println("Sem registros.");
				break;
			}
			linha = bf.readLine();
		}
		bf.close();

		return lista;
	}
}
