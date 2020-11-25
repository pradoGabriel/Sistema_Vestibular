package Model;

public class CandidatoModel {
	// Propriedades
	private String nome;
	private String rg;
	private String cpf;
	private int idade;
	private CandidatoModel prox;

	// Construtor

	public CandidatoModel(String nome, String rg, String cpf, int idade) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.idade = idade;
	}

	// Encapsulamento
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public CandidatoModel getProx() {
		return prox;
	}

	public void setProx(CandidatoModel prox) {
		this.prox = prox;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: "+nome+"\nCpf :"+cpf;
	}
}
