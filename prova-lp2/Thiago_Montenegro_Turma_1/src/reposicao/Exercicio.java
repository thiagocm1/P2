package reposicao;

public class Exercicio {

	private String nome;
	private int bpm;
	private int aguaPerdida;

	
	public Exercicio(String nome, int bpm, int agua) throws Exception{
		if(nome == null || nome.trim().isEmpty()){
			throw new Exception("Nome do exercicio nao pode ser nulo ou vazio");
		}
		if(bpm < 0){
			throw new Exception("Quantidade de batimentos por segundo invalida");
		}
		if(agua < 0){
			throw new Exception("Quantidade de agua perdida invalida");
		}
		this.nome = nome;
		this.bpm = bpm;
		this.aguaPerdida = agua;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getBpm() {
		return bpm;
	}
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
	public int getAguaPerdida() {
		return aguaPerdida;
	}
	public void setAguaPerdida(int aguaPerdida) {
		this.aguaPerdida = aguaPerdida;
	}
	
	@Override
	public String toString(){
		return "("+ getNome() +", " + getBpm() + "bpm, " + getAguaPerdida() + "ml/h)";
	}
	 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aguaPerdida;
		result = prime * result + bpm;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	
	
	
}
