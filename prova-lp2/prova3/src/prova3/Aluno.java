package prova3;

import java.util.HashSet;

public class Aluno {
	
	private String nome;
	private String matricula;
	boolean repetente;
	HashSet<Aluno> alunos;
	public Aluno(String nomeAluno, String matricula, boolean rep) throws Exception{
		
		if(nomeAluno == null || nomeAluno.trim().isEmpty()){
			throw new Exception("O nome do aluno nao pode ser nulo ou vazio");
		}
		if(matricula == null || matricula.trim().isEmpty()){
			throw new Exception("A matricula nao pode ser nula ou vazia");
		}
		this.nome = nomeAluno;
		this.matricula = matricula;
		this.repetente = rep;
		
	}
	
	public void cadastraAlunos(String nomeAluno, String matricula, boolean rep) throws Exception{
		Aluno novoAluno = new Aluno(nomeAluno, matricula, rep);
		alunos.add(novoAluno);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isRepetente() {
		return repetente;
	}

	public void setRepetente(boolean repetente) {
		this.repetente = repetente;
	}
	
	public boolean contemAluno(String matricula){
		if(this.getMatricula().equalsIgnoreCase(matricula)){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (repetente ? 1231 : 1237);
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (repetente != other.repetente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  nome + " - " + matricula;
	}
	
	public String consultaAluno(String matricula) throws Exception {
		for (Aluno aluno : alunos) {
			if(aluno.getMatricula().equalsIgnoreCase(matricula)){
				return matricula;
			}
		}	
		return null;
	
	}
}
