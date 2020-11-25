package Controller;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import Model.CursoModel;

import java.io.FileWriter;

public class ManipuladorArquivoController {

	public void gravar(String linha, String path) throws IOException {
		BufferedWriter bw ;
		if(linha!=""){
			bw = new BufferedWriter(new FileWriter(path, true));
		}
		else{
			bw = new BufferedWriter(new FileWriter(path, false));
		}
		
		bw.append(linha + "\n");
		bw.close();
		System.out.println("Registro gravado com sucesso!");
	}

	public ListaCandidatosController lerCandidatos() throws IOException {
		ListaCandidatosController lista = new ListaCandidatosController();
		BufferedReader bf = new BufferedReader(new FileReader("candidatos.txt"));
		String linha = null;
		boolean aux=false;
		while (true) {
			linha = bf.readLine();
			if (linha != null) {
				aux = true;
				String array[] = new String[6];
				array = linha.split(";");
				lista.adicionaFinal(array[0], array[1], (array[2]), Integer.parseInt(array[3]));
			} else {
				if(aux == false){
					System.out.println("Sem registros.");
				}
				break;
			}
		}
		bf.close();

		return lista;
	}
	
	public ListaSituacaoController lerSituacao() throws IOException {
		ListaSituacaoController lista = new ListaSituacaoController();
		BufferedReader bf = new BufferedReader(new FileReader("situacao.txt"));
		String linha = null;
		boolean aux=false;
		while (true) {
			linha = bf.readLine();
			if (linha != null) {
				aux = true;
				String array[] = new String[4];
				array = linha.split(";");
				lista.adicionaFinal(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]),array[3]);
			} else {
				if(aux == false){
					System.out.println("Sem registros.");
				}
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

		public void gravaCursos(ListaCursosController lista) throws Exception {
			BufferedWriter bw2 = new BufferedWriter(new FileWriter("cursos.txt", false));
			BufferedWriter bw = new BufferedWriter(new FileWriter("cursos.txt", true));
			
			String gravacao = lista.geraVetor();
			String vet[] = gravacao.split("/");
			int tamanho = vet.length;
			bw2.append("");
			for (int i = 0; i < tamanho; i++) {
				bw.append(vet[i]+ "\n");
			}
			bw.close();
		}

		public ListaCursosController lerCursos() throws IOException {
			ListaCursosController lista = new ListaCursosController();
			BufferedReader bf = new BufferedReader(new FileReader("cursos.txt"));
			String linha = "";
			while (true) {
				linha = bf.readLine();
				if (linha != null) {
					String array[] = new String[4];
					array = linha.split(";");
					lista.adicionaFinal(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]),
							Integer.parseInt(array[3]));
				} else {
					break;
				}
			}
			bf.close();

			return lista;
		}
}
