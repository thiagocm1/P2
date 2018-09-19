package prova3;

public class MatriculaException extends Exception{

	public MatriculaException(String mensagem) throws Exception {
		throw new Exception("Aluno nao matriculado");
		}
	
	public void MatriculaNomeException(String nome) throws Exception{
	
		if (nome == null || nome.trim().isEmpty()){
			throw new Exception("Nome do aluno nao esta cadastrado");
		}
	}
	
	
	
}
