package Model;

public class CampusModel {
	private String nomeCampus;
	private CampusModel prox;
	
	
	public CampusModel(String nomeCampus) {
		super();
		this.nomeCampus = nomeCampus;
		
	}


	public CampusModel getProx() {
		return prox;
	}


	public void setProx(CampusModel prox) {
		this.prox = prox;
	}


	public String getNomeCampus() {
		return nomeCampus;
	}


	public void setNomeCampus(String nomeCampus) {
		this.nomeCampus = nomeCampus;
	}
	
	public String toString(){
		String retorno="Campus:"+this.nomeCampus;
		return retorno;
	}
	
	public int compareTo(CampusModel campus) {
			return this.nomeCampus.compareTo(campus.nomeCampus);
	}




}