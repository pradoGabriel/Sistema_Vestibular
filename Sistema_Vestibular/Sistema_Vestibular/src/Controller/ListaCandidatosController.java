package Controller;

import Interface.ILista;
import Model.CandidatoModel;

public class ListaCandidatosController implements ILista {

	private CandidatoModel inicio;
	static int count;

	public ListaCandidatosController() {
		count = 0;
		inicio = null;
	}

	public synchronized void adicionaFinal(String nome, String rg, int cpf, int idade) {
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
		count++;
	}

	public synchronized void AdicionaInicio(String nome, String rg, int cpf, int idade) {
		CandidatoModel candidato = new CandidatoModel(nome, rg, cpf, idade);
		candidato.setProx(inicio);
		inicio = candidato;
		count++;
	}
	@Override
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
			count--;
		}
		return r;
	}

	public synchronized void escolhePosicao(String nome, String rg, int cpf, int idade, int pos) {
		CandidatoModel CandidatoModel = new CandidatoModel(nome, rg, cpf, idade);

		if (pos == 1) {
			AdicionaInicio(nome, rg, cpf, idade);
		} else {
			CandidatoModel aux = inicio;
			int cont = 1;

			while (aux.getProx() != null && count < pos - 1) {
				aux = aux.getProx();
				cont++;
			}

			if (cont == pos - 1) {
				CandidatoModel.setProx(aux.getProx());
				aux.setProx(CandidatoModel);
				count++;
			} else {
				System.out.println("Posição inválida!");
			}
		}
	}

	public synchronized String escolheRemove(int pos) {
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
				count--;
				return e;
			}
		}
	}
	@Override
	public String RemoveInicio() {
		String r = null;
		if (inicio == null) {
			System.out.println("Lista Vazia");
		} else {
			r = inicio.getNome();
			inicio = inicio.getProx();
			count--;
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

	public void ordenarPorNome() {
		CandidatoModel aux = inicio;
		String candidatos[] = new String[count];
		int contador = 0;
		while (contador < count) {
			candidatos[contador] = aux.getNome();
			aux = aux.getProx();
			contador++;
		}
		ordenarCandidatos(candidatos);
	}

	public void ordenarCandidatos(String[] vet) {
		// metodo de ordenação quicksort
		quickSort(vet, 0, vet.length - 1);
		int num = 0;
		System.out.println("Lista de candidatos ordenada por nome: ");
		for (String candidato : vet) {
			num++;
			System.out.println(num + "- " + candidato);
		}
	}

	private static void quickSort(String[] vet, int ini, int fim) {
		if (ini < fim) {
			int divisao = particao(vet, ini, fim);
			quickSort(vet, ini, divisao - 1);
			quickSort(vet, divisao + 1, fim);
		}

	}

	private static int particao(String[] vet, int ini, int fim) {
		int i = ini + 1, f = fim;
		String aux;
		String pivo = vet[ini];
		while (i <= f) {
			while (i <= fim && vet[i].compareToIgnoreCase(pivo) <= 0)
				i++;
			while (pivo.compareToIgnoreCase(vet[f]) < 0)
				--f;
			if (i < f) {
				aux = vet[i];
				vet[i] = vet[f];
				vet[f] = aux;
				++i;
				--f;
			}
		}
		if (ini != f) {
			vet[ini] = vet[f];
			vet[f] = pivo;
		}

		return f;
	}
}
