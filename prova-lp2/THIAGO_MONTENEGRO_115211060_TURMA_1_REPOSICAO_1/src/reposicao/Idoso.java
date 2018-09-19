package reposicao;

import java.util.ArrayList;

import java.util.List;

public class Idoso {
	private String nome;
	private double altura;
	private int peso;
	private int idade;
	private List<Exercicio> programa;
	private PressaoArterial pressao;
	private int pad;
	private int pas;
	public Idoso(String nome, double altura, int peso, int idade) throws Exception{
		if(nome == null || nome.trim().isEmpty()){
			throw new Exception("Nome não pode ser nulo ou vazio");
		}
		if(altura < 0){
			throw new Exception("Altura invalida");
		}
		if(idade < 0){
			throw new Exception("Idade invalida");
		}
		
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.idade = idade;
		setPressao(new PressaoArterial(pad,pas));
		setPad(pad);
		setPas(pas);
		programa = new ArrayList<>();
		
	}

	public boolean adicionaExercicio(String nome, int bpm, int aguaPerdida) throws Exception {
		Exercicio novoExercicio = new Exercicio(nome, bpm, aguaPerdida);
		if(programa.contains(novoExercicio)){
			return false;
		}
		return programa.add(novoExercicio);
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Exercicio> getPrograma() {
		return programa;
	}

	public void setPrograma(List<Exercicio> programa) {
		this.programa = programa;
	}

	public int aguaPerdida(int horas) {
		int total = 0;
		
		for (Exercicio exercicio : programa) {
			total += exercicio.getAguaPerdida() * horas/programa.size();
			
		}
		return total;
		
	}
	
	
	public int getPad() {
		return pad;
	}

	public void setPad(int pad) {
		this.pad = pad;
	}

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		this.pas = pas;
	}

	public void setPA(int pad, int pas) throws Exception{
		PressaoArterial pressao = new PressaoArterial(pad,pas);
	}

	public void setPA(PressaoArterial pressaoArterial) throws Exception {
		pressaoArterial.setPA(pad, pas);
	}
	
		 
	public boolean equals(Idoso outroIdoso) {
		if (outroIdoso instanceof Idoso) {
			if(this.programa.size() == outroIdoso.programa.size()){
				int verdade = 0;
 				for (int i = 0; i < programa.size(); i++) {
					if(this.programa.get(i).getNome() == outroIdoso.programa.get(i).getNome()){
						verdade += 1;
					}
				}
 				if(verdade != programa.size()){
 					return false;
 				}
 				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return getNome();
	}

	public PressaoArterial getPressao() {
		return pressao;
	}

	public void setPressao(PressaoArterial pressao) {
		this.pressao = pressao;
	}

	public String classificaPA() {
		if(getPressao().getPAD() < 80 || getPressao().getPAS() < 120){
			return "Normal";
		}
		else if(( 80 < getPressao().getPAD()||getPressao().getPAD() < 89) || 120 < getPressao().getPAS() || getPressao().getPAS() < 139){
			return "Normal";
		}
		else if((90 < getPressao().getPAD() || getPressao().getPAD() < 99) || (140 < getPressao().getPAS() || getPressao().getPAS() < 159 )){
			return "Hipertensao1";
		}
		else if(getPressao().getPAD() > 99 || getPressao().getPAS() > 159){
			return "Hipertensao2";
		}
		return null; 
		
	}



	

}

