package Model;

public class SituacaoModel {
	private String nome;
	private String cpf;
	private int resultado;
	private String detalhes;
	

	private SituacaoModel prox;

	public SituacaoModel(String nome, String cpf, int resultado, String detalhes) {
		this.nome = nome;
		this.cpf = cpf;
		this.resultado = resultado;
		this.detalhes = detalhes;
	}

	public String getNome() {
		return nome;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	public SituacaoModel getProx() {
		return prox;
	}

	public void setProx(SituacaoModel prox) {
		this.prox = prox;
	}
		

	@Override
	public String toString() {
		return "Nome: "+nome + "\n Cpf: "+cpf;
	}

}
