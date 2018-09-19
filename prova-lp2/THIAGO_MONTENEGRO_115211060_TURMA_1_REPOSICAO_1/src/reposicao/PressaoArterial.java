package reposicao;

public class PressaoArterial {
	private int PAD;
	private int PAS;
	private Idoso idoso;
	
	public PressaoArterial(int pad, int pas) throws Exception{
		if(pad < 0){
			throw new Exception("Pressao arterial diastolica - PAS - invalida");
		}
		if(pas < 0){
			throw new Exception("Pressao arterial siastolica  - PAS - invalida");
		}
		this.PAD = pad;
		this.PAS = pas;
	}


	public int getPAD() {
		return PAD;
	}


	public void setPAD(int pAD) {
		PAD = pAD;
	}


	public int getPAS() {
		return PAS;
	}


	public void setPAS(int pAS) {
		PAS = pAS;
	}
	public void setPA(int pad, int pas) throws Exception{
		PressaoArterial pressao = new PressaoArterial(pad, pas);
	}
	
}
