package ipiranga;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class IpirangaImpostoSimplesBR implements IpirangaIf{
	
	private List<Contribuinte> pessoas;

	public IpirangaImpostoSimplesBR() {
		this.pessoas = new ArrayList<Contribuinte>();
	}

	public Taxista criaTaxista(String nome, String cpf, int quilometros, int passageiros) throws Exception{
		return new Taxista(nome, cpf, quilometros,passageiros);
	}
	
	public Professor criaProfessor(String nome, String cpf, double despesas, double salario) throws Exception{
		return new Professor(nome, cpf, despesas, salario);
	}
	
	public Caminhoneiro criaCaminhoneiro(String nome, String cpf, int quilometros, int carga) throws Exception{
		return new Caminhoneiro(nome, cpf, quilometros, carga);
	}
	

	public void addPessoas(Contribuinte novoContribuinte){
		pessoas.add(novoContribuinte);
	}

	
	public int qtdContribuintes(){
		return pessoas.size();
	}
	
	@Override
	public boolean removerContribuinte(String cpf) throws Exception {
		for (Contribuinte contribuinte : pessoas) {
			if(contribuinte.getCpf().equals(cpf)){
				return pessoas.remove(contribuinte);
			}
		}
		return false;
	}
	

	@Override
	public void adicionarBem(String cpf, double valor) throws Exception {
		int bem = 0;
		for (Contribuinte contribuinte : pessoas) {
			contribuinte.getCpf().equals(cpf);
			bem += valor;
			contribuinte.setBensAcumulados(bem);
		}
	}


	@Override
	public double calcularImpostos(String cpf) throws Exception {
		double impostos = 0;	
		for (Contribuinte contribuinte : pessoas) {
			impostos += contribuinte.calculaTributacao();
		}
		return impostos;
	}

	@Override
	public List<Contribuinte> getContribuintesOrdenadosPorImposto() {
		Collections.sort(pessoas);
		return pessoas;
	}

	@Override
	public String getString(String cpf) {
		for (Contribuinte contribuinte : pessoas) {
			if(contribuinte.getCpf().equals(cpf)){
				return contribuinte.toString();
			}
		}
		return null;
	}

	@Override
	public double getBens(String cpf) {
		for (Contribuinte contribuinte : pessoas) {
			if(contribuinte.getCpf().equals(cpf)){
				return contribuinte.getBensAcumulados();
			}
		}
		return 0;
	}

	@Override
	public double getImposto(String cpf) {
		for (Contribuinte contribuinte : pessoas) {
			if(contribuinte.getCpf().equalsIgnoreCase(cpf)){
				return contribuinte.calculaTributacao();
			}
		}
		return 0;
	}

	@Override
	public Set<String> getContribuintesAcimaLimiar() {
		for (Contribuinte contribuinte : pessoas) {
			if(contribuinte.sinalRiqueza() == true){
				contribuinte.getClass();
			}
		}
		return null;
	}


	@Override
	public void adicionarTaxista(String nome, String cpf, int quilometros, int passageiros) throws Exception {
		pessoas.add(criaTaxista(nome, cpf, passageiros, passageiros));
		
	}


	@Override
	public void adicionarCaminhoneiro(String nome, String cpf, int quilometros, int carga) throws Exception {
		pessoas.add(criaCaminhoneiro(nome, cpf, carga, carga));
		
	}


	@Override
	public void adicionarProfessor(String nome, String cpf, double despesas, double salario) throws Exception {
		pessoas.add(criaProfessor(nome, cpf, despesas, salario));
		
	}
	


}
