package excecoes;

public class AvialacaoException extends Exception {

	public void AvialacaoException(String nome) throws Exception {
		if(nome == null || nome.trim().isEmpty()){
			throw new Exception("Nome da atividade invalido.");
		}
	}
	
	public void AvaliacaoException(String matricula) throws Exception{
		if(matricula == null || matricula.trim().isEmpty()){
			throw new Exception("Tipo de atividade invalido.");
		}
	}
	
	public void NotaException(int nota) throws Exception{
		if(nota < 0){
			throw new Exception("Nota invalida.");
		}
	}
	

	
	
}
