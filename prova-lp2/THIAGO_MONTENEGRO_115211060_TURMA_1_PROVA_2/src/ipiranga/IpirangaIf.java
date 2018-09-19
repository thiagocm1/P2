
package ipiranga;

import java.util.List;
import java.util.Set;

public interface IpirangaIf {

	void adicionarTaxista(String nome, String cpf, int quilometros, int passageiros) throws Exception;

	void adicionarCaminhoneiro(String nome, String cpf, int quilometros, int carga) throws Exception;

	void adicionarProfessor(String nome, String cpf, double despesas, double salario) throws Exception;

	void adicionarBem(String cpf, double valor) throws Exception;

	boolean removerContribuinte(String cpf) throws Exception;

	double calcularImpostos(String cpf) throws Exception;

	List<Contribuinte> getContribuintesOrdenadosPorImposto();

	String getString(String cpf);

	double getBens(String cpf);

	double getImposto(String cpf);

	Set<String> getContribuintesAcimaLimiar();

}
