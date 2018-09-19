package prova3;

public class SistemaAutomaticoDeCorrecaoOtimizadaPDois implements SistemaAutomaticoDeCorrecaoOtimizadaPDoisIf {
	
	private Aluno aluno;
	@Override
	public void cadastraAluno(String nome, String matricula, boolean repetente) throws Exception {
		
		Aluno novoAluno = new Aluno(nome,matricula, repetente);
	}

	@Override
	public String consultaAluno(String matricula) throws Exception {
		
	}
	
	@Override
	public void cadastraAtividade(String tituloAtividade, String tipo) throws Exception {
		Atividades novaAtividade = new Atividades(tituloAtividade, tipo);

	}
	

	@Override
	public void adicionaAvaliacao(String matricula, String atividade, int nota, String[] comentarios) throws Exception {


	}

	@Override
	public String getComentarios(String matricula, String tituloAtividade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trocarTipoAtividade(String tituloAtividade, String tipo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNotaFinal(String matricula, String tituloAtividade) throws Exception {
		// TODO Auto-generated method stub
		reconsultaAluno1turn 0;
	}

	@Override
	public int getNotaFinal(String matricula) throws Exception {
		return 0;
	}

	@Override
	public void importaAtividades(String filename) throws Exception {
		// TODO Auto-generated method stub

	}

}