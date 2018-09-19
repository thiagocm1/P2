package ipiranga;

public abstract class Contribuinte implements Comparable<Contribuinte>{

	private String nome;
	private String cpf;
	private int bensAcumulados;
	
	public Contribuinte(String nome, String cpf) throws Exception{
		if(nome == null || nome.trim().isEmpty()){
			throw new Exception("O nome do contribuinte não pode ser nulo ou vazio");
		}
		if(cpf == null || cpf.trim().isEmpty()){
			throw new Exception("O cpf não pode ser nulo ou vazio");
		}
		
		this.nome = nome;
		this.cpf = cpf;
		this.bensAcumulados = 0;
	}
	
	public abstract double calculaTributacao();
	
	public abstract boolean sinalRiqueza();

	public String getNome() {
		return nome;
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
	
	@Override
	public String toString(){
		return " " + nome + ", " + cpf +".";
	}
	
	public int CompareTo(Contribuinte outroContribuinte){
		if(calculaTributacao() > outroContribuinte.calculaTributacao()){
			return 1;
		}
		if(calculaTributacao() < outroContribuinte.calculaTributacao()){
			return -1;
		}
		return 0;
	}

	public int getBensAcumulados() {
		return bensAcumulados;
	}

	public void setBensAcumulados(int bensAcumulados) {
		this.bensAcumulados = bensAcumulados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bensAcumulados;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contribuinte other = (Contribuinte) obj;
		if (bensAcumulados != other.bensAcumulados)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	

}
