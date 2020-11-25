package Controller;

import Model.CampusModel;
import Model.CandidatoModel;

public class ListaCandidatosController{

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
	
	
	
	public synchronized int tamanho(){
		return count;
	}
	
	public CandidatoModel[] toVet() {
		CandidatoModel aux = inicio;
		CandidatoModel candidatos[] = new CandidatoModel[count];
		int contador = 0;
		while (contador < count) {
			candidatos[contador] = aux;
			aux = aux.getProx();
			contador++;
		}
		return candidatos;
	}

	public String percorre() {
		CandidatoModel aux = inicio;
		String r = "";
		int cont = 1;
		while (aux != null) {
			r = r + cont + "- " + aux.getNome() + "\n" ;
			aux = aux.getProx();
			cont++;
		}
		return r;
	}

	public ListaCandidatosController ordenarPorNome() {
		CandidatoModel aux = inicio;
		CandidatoModel candidatos[] = new CandidatoModel[count];
		int contador = 0;
		while (contador < count) {
			candidatos[contador] = aux;
			aux = aux.getProx();
			contador++;
		}
		return ordenarCandidatos(candidatos);
	}

	public ListaCandidatosController ordenarCandidatos(CandidatoModel[] vet) {
		// metodo de ordenação quicksort
		quickSort(vet, 0, vet.length - 1);
		System.out.println("Lista de candidatos ordenada por nome: ");
		ListaCandidatosController listaOrdenada = new ListaCandidatosController();
		for (CandidatoModel candidato : vet) {
			listaOrdenada.adicionaFinal(candidato.getNome(), candidato.getRg(), candidato.getCpf(), candidato.getIdade());
		}
		return listaOrdenada;
	}

	private static void quickSort(CandidatoModel[] vet, int ini, int fim) {
		if (ini < fim) {
			int divisao = particao(vet, ini, fim);
			quickSort(vet, ini, divisao - 1);
			quickSort(vet, divisao + 1, fim);
		}

	}

	private static int particao(CandidatoModel[] vet, int ini, int fim) {
		int i = ini + 1, f = fim;
		CandidatoModel aux = null;
		CandidatoModel pivo = vet[ini];
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
