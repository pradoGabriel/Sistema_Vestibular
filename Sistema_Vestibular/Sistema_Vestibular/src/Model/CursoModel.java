package Model;

public class CursoModel {
	// Propriedades
	private String nomeDoCurso;
	private int periodo;
	private int quantidadeSemestres;
	private int vagas;
	private CursoModel prox;
	private CursoModel anterior;

	// Encapsulamento
	public String getNomeDoCurso() {
		return nomeDoCurso;
	}

	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getQuantidadeSemestres() {
		return quantidadeSemestres;
	}

	public void setQuantidadeSemestres(int quantidadeSemestres) {
		this.quantidadeSemestres = quantidadeSemestres;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public CursoModel getProx() {
		return prox;
	}

	public void setProx(CursoModel prox) {
		this.prox = prox;
	}

	public CursoModel getAnterior() {
		return anterior;
	}

	public void setAnterior(CursoModel anterior) {
		this.anterior = anterior;
	}

}
