package ipiranga;

public class Caminhoneiro extends Contribuinte {

	private int km;
	private int carga;
	

	public Caminhoneiro(String nome, String cpf, int km, int carga) throws Exception {
		super(nome, cpf);
		if(km < 0){
			throw new Exception("O valor de km rodados não poder ser inferior a 0");
		}
		if(carga < 0){
			throw new Exception("O número de cargas não pode ser inferior a 0");
		}
		this.km = km;
		this.carga = carga;
	}

	public double calculaTributacao() {
		return ((getKm() * 0.01) + (calculaCarga()));
	}

	public int calculaCarga() {
		double precoCarga = 0;
		if (getCarga() <= 10) {
			precoCarga = 50;
		} else if (getCarga() > 10) {
			precoCarga = 500 * getCarga() * 100;
		}
		return (int) precoCarga;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	@Override
	public String toString() {
		return "[CAMINHONEIRO]" + super.toString();
	}

	@Override
	public boolean sinalRiqueza() {
		if (calculaTributacao() > 100.000) {
			return true;
		} else {
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
