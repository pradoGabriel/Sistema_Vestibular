package Controller;

import Model.CursoModel;

public class ListaCursosController {
    private CursoModel inicio = null, fim = null;
    private int tamanho = 0;

    public void adicionaInicio(String nomeDoCurso, int periodo, int quantSemestres, int vagas) {
        CursoModel novo = new CursoModel(nomeDoCurso, periodo, quantSemestres, vagas);
        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            inicio.setAnterior(novo);
            novo.setProx(inicio);
            inicio = novo;
        }
        tamanho++;
    }

    public String removeInicio() {
        if (estaVazia())
            return null;

        CursoModel aux = inicio;
        if (inicio.getProx() != null) {
            inicio = inicio.getProx();
            inicio.getAnterior().setProx(null);
            inicio.setAnterior(null);
        } else {
            inicio = null;
            fim = null;
        }
        tamanho--;
        System.out.println("\nCurso do inicio da estrutura foi removido com sucesso!");
        return aux.getNomeDoCurso();
    }

    public void adicionaFinal(String nomeDoCurso, int periodo, int quantSemestres, int vagas) {
        CursoModel novo = new CursoModel(nomeDoCurso, periodo, quantSemestres, vagas);
        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnterior(fim);
            fim.setProx(novo);
            fim = novo;
        }
        tamanho++;
    }

    public String removeFinal() {
        if (estaVazia())
            return null;

        CursoModel aux = fim;
        if (fim.getAnterior() != null) {
            fim = fim.getAnterior();
            fim.getProx().setAnterior(null);
            fim.setProx(null);
        } else {
            fim = null;
            inicio = null;
        }
        tamanho--;
        System.out.println("\nCurso do final da estrutura foi removido com sucesso!");
        return aux.getNomeDoCurso();
    }
    
    public void adicionaNaPosicao(String nomeDoCurso, int periodo, int quantSemestres, int vagas, int posicao) {
        CursoModel novo = new CursoModel(nomeDoCurso, periodo, quantSemestres, vagas);
        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else if (posicao == 1) {
            adicionaInicio(nomeDoCurso, periodo, quantSemestres, vagas);
        } else {
            CursoModel aux = inicio;
            int cont = 1;
            while (aux.getProx() != null && cont < posicao - 1) {
                aux = aux.getProx();
                cont++;
            }
            if (cont == posicao - 1) {
                novo.setProx(aux.getProx());
                aux.setProx(novo);
                novo.setAnterior(aux);
                novo.getProx().setAnterior(novo);
                tamanho++;
            } else {
                System.out.println("Posição inválida!");
            }
        }
    }

    public void removeCurso(String elemento) {
        CursoModel pos = buscaCurso(elemento);
        if (pos != null) // se existe o No a ser deletado
        {
            if (inicio != fim) // se so existe um No na lista
            {
                if (pos == inicio) // se o No esta no comeco
                {
                    inicio = pos.getProx();
                    pos.getProx().setAnterior(null);
                } else if (pos == fim) // se o No esta no fim
                {
                    fim = pos.getAnterior();
                    pos.getAnterior().setProx(null);
                } else // se o no esta no meio
                {
                    pos.getAnterior().setProx(pos.getProx());
                    pos.getProx().setAnterior(pos.getAnterior());
                }
                pos.setAnterior(null);
                pos.setProx(null);
                tamanho--;
            } else {
                inicio = null;
                fim = null;
                tamanho--;
            }
            System.out.println("\nCurso removido com sucesso!");
        } else
            System.out.println("Ops, elemento nao encontrado!");
    }
    
    public void exibeLista() {
        if (estaVazia()) {
            System.out.println("Ops, a lista está vazia!");
        } else {
            CursoModel aux = inicio;
            int contador = 1;
            while (aux != null) {
                System.out.println(contador + "- " + aux.getNomeDoCurso());
                aux = aux.getProx();
                contador++;
            }
            System.out.println();
        }
    }

    public CursoModel buscaCurso(String curso) {
        CursoModel busca = inicio;
        while ((busca != null) && (busca.getNomeDoCurso().compareToIgnoreCase(curso)!=0)) {
            busca = busca.getProx();
        }
        if ((busca != null) && (busca.getNomeDoCurso().compareToIgnoreCase(curso) == 0))
            return busca;
        else{
            System.out.println("Curso inexistente ou digitado incorretamente!");
            return null;
        }
    }


    private boolean estaVazia() {
        return fim == null && inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public ListaCursosController ordenarPorNomeCresc() {
        CursoModel aux = inicio;
		CursoModel cursos[] = new CursoModel[tamanho];
		int contador = 0;
		while (contador < tamanho) {
			cursos[contador] = aux;
			aux = aux.getProx();
			contador++;
		}
        if (estaVazia()) {
            System.out.println("Ops, a lista está vazia!");
        } else {
            // chamando o método de ordenação em merge sort (String)
            sort(cursos, 0, cursos.length - 1);
        }
        ListaCursosController listaNomeCresc = new ListaCursosController();
        for (CursoModel curso : cursos) {
            listaNomeCresc.adicionaFinal(curso.getNomeDoCurso(), curso.getPeriodo(), curso.getQuantidadeSemestres(), curso.getVagas());
        }
        return listaNomeCresc;
    }

    // Mescla duas sublistas de vetor[].
    // Primeira sublista: vetor[esquerdo...meio]
    // Segunda sublista: vetor[meio...direito]
    private void merge(CursoModel[] vetor, int esquerdo, int meio, int direito) {
        // Encontra o tamanho das duas sublistas a serem mescladas
        int n1 = meio - esquerdo + 1;
        int n2 = direito - meio;

        // Cria listas temporarias
        CursoModel E[] = new CursoModel[n1];
        CursoModel D[] = new CursoModel[n2];

        // Copia os dados para as listas temporarias
        for (int i = 0; i < n1; i++)
            E[i] = vetor[esquerdo + i];
        for (int j = 0; j < n2; j++)
            D[j] = vetor[meio + 1 + j];

        // Index inicial da primeira e segunda sublista
        int i = 0, j = 0;

        // Index inicial da sublista mesclada
        int k = esquerdo;
        while (i < n1 && j < n2) {
            if (E[i].getNomeDoCurso().compareToIgnoreCase(D[j].getNomeDoCurso()) <= 0) {
                vetor[k] = E[i];
                i++;
            } else {
                vetor[k] = D[j];
                j++;
            }
            k++;
        }

        // Copia elementos restantes de E[] se houver
        while (i < n1) {
            vetor[k] = E[i];
            i++;
            k++;
        }

        // Copia elementos restantes de R[] se houver
        while (j < n2) {
            vetor[k] = D[j];
            j++;
            k++;
        }
    }

    // Função principal que ordena a lista[esq...dir] usando o merge()
    private void sort(CursoModel[] vetor, int esquerdo, int direito) {
        if (esquerdo < direito) {
            // Encontrar o centro
            int meio = (esquerdo + direito) / 2;

            // Organizar as duas partes
            sort(vetor, esquerdo, meio);
            sort(vetor, meio + 1, direito);

            // Juntar as partes organizadas
            merge(vetor, esquerdo, meio, direito);
        }
    }

    public String geraVetor() {
        CursoModel aux = inicio;
        String r = "";
        while (aux != null) {
            r = r + aux.getNomeDoCurso() + ";" + aux.getPeriodo() + ";" + aux.getQuantidadeSemestres() + ";"
                    + aux.getVagas() + "/";
            aux = aux.getProx();
        }
        return r;
    }
}