package Controller;

import Model.CandidatoModel;
import Model.SituacaoModel;

public class ListaSituacaoController {

	private SituacaoModel inicio;
	static int count;

	public ListaSituacaoController() {
		count = 0;
		inicio = null;
	}

	public void adicionaFinal(String nome, int cpf, int resultado, String detalhes) {
		if (inicio == null) {
			SituacaoModel situacao = new SituacaoModel(nome, cpf, resultado, detalhes);
			inicio = situacao;
		} else {
			SituacaoModel aux = inicio;
			while (aux.getProx() != null) {
				aux = aux.getProx();
			}
			SituacaoModel situacao = new SituacaoModel(nome, cpf, resultado, detalhes);
			aux.setProx(situacao);
		}
		count++;
	}

	public String percorre() {
		SituacaoModel aux = inicio;
		String r = " ";
		int num = 1;
		r="\n***********************************";
		r+="\nLista dos candidatos Aprovados: ";
		while (aux != null) {
			if (aux.getResultado() == 1) {
				r = r + "\n" + num + "- " + aux.getNome();
				num++;
			}
			aux = aux.getProx();
		}
		r+="\n***********************************";
		num = 1;
		aux = inicio;
		r+="\nLista dos candidatos Reprovados: ";
		while (aux != null) {
			if (aux.getResultado() == 2) {
				r = r + "\n" + num + "- " + aux.getNome();
				num++;
			}
			aux = aux.getProx();
		}
		r+="\n***********************************\n";
		return r;

	}

	public ListaSituacaoController ordenarPorNome() {
		SituacaoModel aux = inicio;
		SituacaoModel avaliados[] = new SituacaoModel[count];
		int contador = 0;
		while (contador < count) {
			avaliados[contador] = aux;
			aux = aux.getProx();
			contador++;
		}
		return ordenarAvaliados(avaliados);
	}
	
	public int tamanho(){
		return count;
	}
	
	public SituacaoModel[] toVet() {
		SituacaoModel aux = inicio;
		SituacaoModel avaliados[] = new SituacaoModel[count];
		int contador = 0;
		while (contador < count) {
			avaliados[contador] = aux;
			aux = aux.getProx();
			contador++;
		}
		return avaliados;
	}

	public ListaSituacaoController ordenarAvaliados(SituacaoModel[] vet) {
		// metodo de ordenação quicksort
		quickSort(vet, 0, vet.length - 1);
		//int num = 0;
		System.out.println("Lista de candidatos ordenada por nome: ");
		//System.out.println(percorre());
		ListaSituacaoController listaOrdenada = new ListaSituacaoController();
		for (SituacaoModel avaliado : vet) {
			listaOrdenada.adicionaFinal(avaliado.getNome(), avaliado.getCpf(), avaliado.getResultado(), avaliado.getDetalhes());
		}
		return listaOrdenada;
	}

	private static void quickSort(SituacaoModel[] vet, int ini, int fim) {
		if (ini < fim) {
			int divisao = particao(vet, ini, fim);
			quickSort(vet, ini, divisao - 1);
			quickSort(vet, divisao + 1, fim);
		}

	}

	private static int particao(SituacaoModel[] vet, int ini, int fim) {
		int i = ini + 1, f = fim;
		SituacaoModel aux;
		SituacaoModel pivo = vet[ini];
		while (i <= f) {
			while (i <= fim && vet[i].getNome().compareToIgnoreCase(pivo.getNome()) <= 0)
				i++;
			while (pivo.getNome().compareToIgnoreCase(vet[f].getNome()) < 0)
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
