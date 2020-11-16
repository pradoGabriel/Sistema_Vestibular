package Controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import Controller.ListaCandidatosController;
import Interface.ILista;
public class ManipuladorArquivoController {
	
	public void gravar(String linha, String path)
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.append(linha + "\n");
		bw.close();
	}

	public ILista ler (ILista lista) throws IOException {
		BufferedReader bf = new BufferedReader (new FileReader ("candidatos.txt"));
		String linha = null;
		while (true) {
			if (linha != null) {
				//Candidato
				//ListaCandidatosController lista = new ListaCandidatosController();
				String array[] = new String[6];
				array = linha.split(";");
				//lista.adicionaFinal(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
			} else
				break;
			linha = bf.readLine();
		}
		bf.close();
		return lista;
	}
}
