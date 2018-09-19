package prova3;

import java.util.HashSet;

public class Atividades {
	private String tituloAtividade;
	private String tipo;
	HashSet<Atividades> catalogoAtividades;
	SistemaAutomaticoDeCorrecaoOtimizadaPDois sb = new SistemaAutomaticoDeCorrecaoOtimizadaPDois();
	public Atividades(String tituloAtividade, String tipo) throws Exception{
		if(tituloAtividade == null || tituloAtividade.trim().isEmpty()){
			throw new Exception("O titulo da atividade nao pode ser nulo ou vazio");
		}
		if(tipo == null || tipo.trim().isEmpty()){
			throw new Exception("O tipo nao pode ser nulo ou vazio");
		}
		
		this.tituloAtividade = tituloAtividade;
		this.tipo = tipo;
		
	}
	
	
	public void adicionaAtividade(String tituloAtividade, String tipo) throws Exception{
		
		Atividades novaAtividade = new Atividades(tituloAtividade, tipo);
		catalogoAtividades.add(novaAtividade);
		
	}
	
	public String consultaAtividades(String tituloAtividade) throws Exception{
		for (Atividades atividades : catalogoAtividades) {
			if(atividades.getTituloAtividade().equalsIgnoreCase(tituloAtividade)){
				return tituloAtividade;
			}
		}
		return null;
	}
	
	
	public boolean contemAtividade(String tituloAtividade) throws Exception{
		return catalogoAtividades.contains(tituloAtividade);
	}
	
	
	public String getTituloAtividade() {
		return tituloAtividade;
	}

	public void setTituloAtividade(String tituloAtividade) {
		this.tituloAtividade = tituloAtividade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
