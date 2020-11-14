package Controller;

import Model.CandidatoModel;

public class ListaCandidatosController {

	private CandidatoModel inicio;

	public ListaCandidatosController() {
		inicio = null;
	}

	public void adicionaFinal(String nome, String rg, int cpf, int idade) {
		if (inicio == null) {
			CandidatoModel candidato = new CandidatoModel(nome, rg, cpf, idade);
			inicio = candidato;
		} else {
			CandidatoModel aux = inicio;
			while (aux.getProx() != null) {
				aux = aux.getProx();
			}
			CandidatoModel candidato = new CandidatoModel(nome, rg, cpf, idade);
			aux.setProx(candidato);
		}
	}

	public void AdicionaInicio(String nome, String rg, int cpf, int idade) {
		CandidatoModel candidato = new CandidatoModel(nome, rg, cpf, idade);
		candidato.setProx(inicio);
		inicio = candidato;
	}

	public String RemoveFinal() {
		String r = null;
		if (inicio == null) {
			System.out.println("Lista Vazia");
		} else {
			if (inicio.getProx() == null) {
				r = inicio.getNome();
				inicio = null;
			} else {
				CandidatoModel aux1 = inicio;
				CandidatoModel aux2 = inicio;

				while (aux1.getProx() != null) {
					aux2 = aux1;
					aux1 = aux1.getProx();
				}

				r = aux1.getNome();
				aux2.setProx(null);
			}
		}
		return r;
	}

	public void escolhePosicao(String nome, String rg, int cpf, int idade, int pos) {
		CandidatoModel CandidatoModel = new CandidatoModel(nome, rg, cpf, idade);

		if (pos == 1) {
			AdicionaInicio(nome, rg, cpf, idade);
		} else {
			CandidatoModel aux = inicio;
			int count = 1;

			while (aux.getProx() != null && count < pos - 1) {
				aux = aux.getProx();
				count++;
			}

			if (count == pos - 1) {
				CandidatoModel.setProx(aux.getProx());
				aux.setProx(CandidatoModel);
			} else {
				System.out.println("Posição inválida!");
			}
		}
	}

	public String escolheRemove(int pos) {
		String e = null;
		int i = 1;
		CandidatoModel aux = inicio;

		if (inicio == null) {
			System.out.println("Lista Vazia!");
			return e;
		}
		if (pos == 1) {
			e = RemoveInicio();
			return e;
		} else {
			while (aux.getProx() != null) {
				aux = aux.getProx();
				i++;
			}
			if (pos > i || pos == 0) {
				System.out.println("Posição Invalida!");
				return e;
			} else if (pos == i) {
				e = RemoveFinal();
				return e;
			} else {
				aux = inicio;
				CandidatoModel aux2 = aux;

				while (pos > 1) {
					aux2 = aux;
					aux = aux.getProx();
					pos--;
				}
				e = aux.getNome();
				aux2.setProx(aux.getProx());
				return e;
			}
		}
	}

	public String RemoveInicio() {
		String r = null;
		if (inicio == null) {
			System.out.println("Lista Vazia");
		} else {
			r = inicio.getNome();
			inicio = inicio.getProx();
		}
		return r;
	}

	public String percorre() {
		CandidatoModel aux = inicio;
		String r = " ";
		while (aux != null) {
			r = r + "\n" + aux.getNome();
			aux = aux.getProx();
		}
		return r;
	}

}
