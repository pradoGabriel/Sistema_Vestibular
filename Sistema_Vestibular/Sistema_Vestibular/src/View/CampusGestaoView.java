package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.ListaCampusController;
import Controller.ManipuladorArquivoController;

public class CampusGestaoView {
	public void menuCampus() throws IOException {
		ListaCampusController campus = new ListaCampusController();
		ManipuladorArquivoController rw = new ManipuladorArquivoController();
		Scanner ler = new Scanner(System.in);
		int op = 0, pos = 0;
		String nomeCampus = "";
		rw.lerCampus(campus);
		System.out.println("***********************************************************************\n"
				+ "OlA, seja bem-vindo a area Gestao dos Campus das Faculdades.!!\n"
				+ "***********************************************************************");
		while (op != 9) {
			System.out.print("1-Adiciona Nome de Campus\n2-Busca de nomes de Campus em ordem de A-Z \n"
					+ "3-Gravar Lista \n4-Remove Campus na Posicao desejada \n7-Exibir lista \n9-Sair");
			op = ler.nextInt();
			switch (op) {
				case 1:
					System.out.print("Inserir nome de um Campus");
					nomeCampus = ler.next();
					campus.AdicionaCampusFinal(nomeCampus);
					break;

				case 2:
					String tVet[] = campus.inseriVet();
					String org[] = campus.mergeSort(tVet, 0, (tVet.length) - 1);
					campus.organizaLista(org);

					System.out.println("<------------------------------------------>\nLista de Campus em Ordem");
					for (int i = 0; i < org.length; i++) {
						System.out.print(org[i] + "\n");
					}
					System.out.println("<------------------------------------------>");
					break;

				case 3:
					int tamanhoVet = campus.contaPercorre();
					String vetor[] = campus.inseriVet();
					rw.gravaCampus(tamanhoVet, vetor);

					break;

				case 4:
					System.out.println("Informe a Posicao que gostaria de remover");
					pos = ler.nextInt();
					String r = campus.escolheRemove(pos);
					System.out.println("O elemento removido da posicao:" + pos + " e : " + r);

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
					System.out.println("Valor Invalido");
			}
		}

	}

}
