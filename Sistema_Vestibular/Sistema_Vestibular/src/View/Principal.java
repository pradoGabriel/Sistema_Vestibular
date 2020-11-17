package View;

import java.io.IOException;
import java.util.Scanner;
import View.InscricaoView;

public class Principal {

	public static void main(String[] args) throws IOException {

		Scanner ler = new Scanner(System.in);
		System.out.println("***********************************************************************\n"
				+ "Olá, seja bem-vindo ao sistema de inscrição do Vestibular FATEC!!\n"
				+ "***********************************************************************");

		int opc = 0;
		while (opc != 9) {
			System.out.println("Digite o número de uma das opções abaixo: \n" 
					+ "1- Sou candidato e quero me inscrever!\n"
					+ "2- Sou membro do CPS/CRA!\n" + "9- Finalizar programa!");

			opc = ler.nextInt();
			switch (opc) {
				case 1:
					InscricaoView iv = new InscricaoView();
					iv.gravarInscricao();
					break;
				case 2:
					break;
				case 9:
					System.out.println("PROGRAMA ENCERRADO!");
					break;
				default:
					System.out.println("DIGITE UMA OPÇÃO VÁLIDA!");

			}
		}
	}
}
