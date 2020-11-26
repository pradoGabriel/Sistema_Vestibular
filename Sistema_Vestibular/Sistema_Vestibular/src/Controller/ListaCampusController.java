package Controller;

import Model.CampusModel;

public class ListaCampusController {

	private CampusModel inicio;

	public ListaCampusController() {
		inicio = null;
	}

	// Adiciona um elemento no inicio da lista
	public void AdicionaInicio(String nomeCampus) {
		CampusModel Campus = new CampusModel(nomeCampus);
		Campus.setProx(inicio);
		inicio = Campus;
	}

	// Adiciona um elemento no final da lista de forma recvursiva
	public void AdicionaCampusFinal(String nomeCampus) {
		if (inicio == null) {
			CampusModel campus = new CampusModel(nomeCampus);
			inicio = campus;
		} else {
			CampusModel aux = inicio;
			aux = FinalInserir(inicio);
			CampusModel campus = new CampusModel(nomeCampus);
			aux.setProx(campus);
		}
	}

	public CampusModel FinalInserir(CampusModel aux) {
		if (aux.getProx() == null) {
			return aux;
		} else {
			return FinalInserir(aux.getProx());
		}
	}
	
	// Escolhe uma posi��o para adicionar um elemento na lista
	public void escolhePosicao(String nomeCampus , int pos){
		CampusModel CampusModelSeg = new CampusModel(nomeCampus);
    if(pos==1){           
        AdicionaInicio(nomeCampus);
    }
    else{       
        CampusModel aux=inicio;
        int count=1;
        while(aux.getProx()!=null && count<pos-1){
            aux=aux.getProx();
            count++;
        }
        if(count==pos-1){
            aux.setProx(CampusModelSeg);
        }
        else{
            System.out.println("Posi��o Inv�lida!");
        }            
    	}
	}

	public String RemoveInicio() {
		String r = null;
		if (inicio == null) {
			System.out.println("Lista Vazia");
		} else {
			r = inicio.getNomeCampus();
			inicio = inicio.getProx();

		}
		return r;
	}

	// Remove Final
	public String RemoveFinal() {
		String r = null;
		if (inicio == null) {
			System.out.println("Lista Vazia");
		} else {
			if (inicio.getProx() == null) {
				r = inicio.getNomeCampus();
				inicio = null;
			} else {
				CampusModel aux1 = inicio;
				CampusModel aux2 = inicio;

				while (aux1.getProx() != null) {
					aux2 = aux1;
					aux1 = aux1.getProx();
				}

				r = aux1.getNomeCampus();
				aux2.setProx(null);
			}
		}
		return r;
	}

	// Escolhe onde Remover elemento
	public String escolheRemove(int pos) {
		String e = null;
		int i = 1;
		CampusModel aux = inicio;

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
				CampusModel aux2 = aux;

				while (pos > 1) {
					aux2 = aux;
					aux = aux.getProx();
					pos--;
				}
				e = aux.getNomeCampus();
				aux2.setProx(aux.getProx());

				return e;
			}
		}
	}

	// realiza a divis�o dos vetores de forma recursiva para depois organizalos
	public static String[] mergeSort(String lista[], int inicio, int fim) {

		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(lista, inicio, meio);
			mergeSort(lista, meio + 1, fim);
			intercalar(lista, inicio, meio, meio + 1, fim);

		}
		return lista;
	}	
	
	//realiza a intercala�ao dos vetore para organiza��o
	public static void intercalar(String lista[], int inicioA, int fimA,
			int inicioB, int fimB){
		int i1 = inicioA; 
		int i2 = inicioB;
		int iaux = inicioA;
		String aux[] = new String[lista.length];
		while (i1 <= fimA && i2 <= fimB) {
			if (lista[i1].compareToIgnoreCase(lista[i2]) <= 0)
				aux[iaux++] = lista[i1++];
			else
				aux[iaux++] = lista[i2++];
		}
		while (i1 <= fimA)
			aux[iaux++] = lista[i1++];
		while (i2 <= fimB)
			aux[iaux++] = lista[i2++];
		for (int i = inicioA; i <= fimB; i++)
			lista[i] = aux[i];
	}

	// Transforma a lista dinamica em vetor
	public String[] inseriVet() {
		int contaM = contaPercorre();
		int novo = 0;
		CampusModel aux = inicio;
		String aux2;
		String r = " ";
		String vet[] = new String[contaM];
		while (aux != null) {
			r = r + "\n" + aux.getNomeCampus();
			aux2 = aux.getNomeCampus();
			aux = aux.getProx();
			if (novo < contaM) {
				vet[novo] = aux2;
				novo = novo + 1;
			}
		}
		return vet;
	}

	// Metodo feito para contagem de elementos na lista
	public int contaPercorre() {
		int contaM = 0;
		CampusModel aux = inicio;
		String r = " ";
		while (aux != null) {
			r = r + "\n" + aux.getNomeCampus();
			aux = aux.getProx();
			contaM++;
		}
		return contaM;
	}

	// Metodo que pega o Vetor Organizado e Retorna em Lista Organizada
	public void organizaLista(String[] listaOrg) {
		int i = 0;
		for (i = 0; i < listaOrg.length; i++) {
			escolhePosicao(listaOrg[i], i + 1);
		}
	}

	// Demonstra a lista
	public String percorre() {
		CampusModel aux = inicio;
		String listaPercorre = " ";
		while (aux != null) {
			listaPercorre = listaPercorre + "\n" + aux.getNomeCampus();
			aux = aux.getProx();
		}
		return listaPercorre;
	}

}
