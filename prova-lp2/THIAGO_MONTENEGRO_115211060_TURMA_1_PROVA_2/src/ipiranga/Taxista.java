package ipiranga;

public class Taxista extends Contribuinte {
	
	private int numPassageiros;
	private int km;
	
	
	public Taxista(String nome, String cpf,int numPassageiros, int km) throws Exception {
		super(nome, cpf);
		if(km < 0){
			throw new Exception("O valor de km rodados não poder ser inferior a 0");
		}
		if(numPassageiros < 0){
			throw new Exception("O Número de passageiros não pode ser inferior a 0");
		}
		
		this.numPassageiros = numPassageiros;
		this.km = km;
	}

	public double calculaTributacao(){
		return ((getNumPassageiros() * 0.5) + (getKm() * 0.001));
	}

	public int getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return "[TAXISTA]" + super.toString();
	}

	@Override
	public boolean sinalRiqueza() {
		if(calculaTributacao() > 150.000){
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public int compareTo(Contribuinte o) {
		if(calculaTributacao() > o.calculaTributacao()){
			return 1;
		}
		if(calculaTributacao() < o.calculaTributacao()){
			return -1;
		}
		return 0;
	}
	
}
