package ipiranga;

public class Professor extends Contribuinte{
	
	private double salario;
	private double despesas;

	
	public Professor(String nome, String cpf,double salario, double despesas) throws Exception {
		super(nome, cpf);
		if(salario < 0){
			throw new Exception("O valor do sálario não pode ser inferior a 0");
		}
		if(despesas < 0){
			throw new Exception("O valor da despesas não pode ser inferiro a 0");
		}
		
		this.salario = salario;
		this.despesas = despesas;
	}

	public double getSalario() {
		return salario;
	}

	public double setSalario(double salario) {
		return this.salario = salario;
	}
	
	public double calculaTributacao(){
		double salMinimo = 880;
		if(getSalario() <= 880){
			return setSalario(getSalario() * (0.05));
		}
		else if(getSalario() <= (salMinimo * 5)){
			return setSalario(getSalario() * (0.1));
		}
		else{
			return setSalario(getSalario() * (0.2));
		}
	}
	
	
	@Override
	public String toString() {
		return "[PROFESSOR]" + super.toString();
	}

	@Override
	public boolean sinalRiqueza() {
		if(calculaTributacao() > 300.000){
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

	public double getDespesas() {
		return despesas;
	}

	public void setDespesas(double despesas) {
		this.despesas = despesas;
	}


}
