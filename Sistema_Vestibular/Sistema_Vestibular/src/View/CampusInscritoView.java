package View;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Controller.ListaCampusController;
import Controller.ManipuladorArquivoController;

public class CampusInscritoView {
	public void menuCampusIncrito() throws IOException {
		ListaCampusController campus = new ListaCampusController();
		ManipuladorArquivoController rw = new ManipuladorArquivoController();
		Scanner ler = new Scanner(System.in);
		int op = 0, pos = 0;
		String nomeCampus = "";
		rw.lerCampus(campus);
		System.out.println("***********************************************************************\n"
				+ "OlA, seja bem-vindo a area de Campus das Faculdades.!!\n"
				+ "***********************************************************************");
		while (op != 9) {
			System.out.print("1 - Trazer nomes em ordem de A-Z \n9 - Caso ja saiba o Campus sair e continuar inscri�ao");
			op = ler.nextInt();
			switch (op) {
				case 1:
					System.out.println("Lista de Campus Disponiveis: ");
					String tVet[] = campus.inseriVet();
					String org[] = campus.mergeSort(tVet, 0, (tVet.length) - 1);
					campus.organizaLista(org);

					System.out.println("<------------------------------------------>\nCampus em Ordem");
					for (int i = 0; i < org.length; i++) {
						System.out.print(org[i] + "\n");
					}
					System.out.println("<------------------------------------------>");
					break;
				case 7:
					System.out.print("<------------------------------------->");
					System.out.print("\nLista:" + campus.percorre());
					System.out.print("\n<------------------------------------->\n");
					break;
				
				case 9:
					System.out.println("Saindo");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Valor invalido");
			}
		}
	}
}
