package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriteCampusController {
	ListaCampusController campus = new ListaCampusController();

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
