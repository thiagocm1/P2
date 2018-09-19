package prova3;

public class Avaliacao {
	
	private String matricula;
	private String tituloAtividade;
	private int nota;
	private String[] comentarios;
	
	public Avaliacao(String matricula, String tituloAtividade, int nota, String[] comentarios ) throws Exception{
		if(tituloAtividade == null || tituloAtividade.trim().isEmpty()){
			throw new Exception("O titulo da atividade nao pode ser nulo ou vazio");
		}
		if(matricula == null || matricula.trim().isEmpty()){
			throw new Exception("O titulo da atividade nao pode ser nula ou vazia");
		}
		
		this.matricula = matricula;
		this.tituloAtividade = tituloAtividade;
		this.nota = nota;
		this.comentarios = comentarios;
	}
		


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTituloAtividade() {
		return tituloAtividade;
	}

	public void setTituloAtividade(String tituloAtividade) {
		this.tituloAtividade = tituloAtividade;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(String[] comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
}
