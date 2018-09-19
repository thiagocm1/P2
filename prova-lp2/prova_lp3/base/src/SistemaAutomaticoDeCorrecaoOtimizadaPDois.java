package prova3;
public class SistemaAutomaticoDeCorrecaoOtimizadaPDois implements SistemaAutomaticoDeCorrecaoOtimizadaPDoisIf {

	@Override
	public void cadastraAluno(String nome, String matricula, boolean repetente) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String consultaAluno(String matricula) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastraAtividade(String tituloAtividade, String tipo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String consultaAtividade(String tituloAtividade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionaAvaliacao(String matricula, String atividade, int nota, String[] comentarios) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getComentarios(String matricula, String tituloAtividade) throws Exception {
		consultaAluno(matricula);
		consultaAtividae(tituloAtividade);
		for(int i = 0; i < lista.size(); i++){
			
		}
	}

	@Override
	public void trocarTipoAtividade(String tituloAtividade, String tipo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNotaFinal(String matricula, String tituloAtividade) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotaFinal(String matricula) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void importaAtividades(String filename) throws Exception {
		// TODO Auto-generated method stub

	}

}
