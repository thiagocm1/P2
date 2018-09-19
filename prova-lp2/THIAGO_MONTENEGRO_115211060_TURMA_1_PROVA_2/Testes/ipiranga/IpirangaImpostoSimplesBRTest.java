package ipiranga;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ipiranga.IpirangaIf;
import ipiranga.IpirangaImpostoSimplesBR;

public class IpirangaImpostoSimplesBRTest {

	private IpirangaIf ipiranga;

	private String ppTaxista = "111.111.111-11";
	private String ppJrTaxista = "222.222.22"
			+ "2-22";
	private String rrCaminhoneiro = "333.333.333-33";
	private String rrJrCaminhoneiro = "444.444.444-44";
	private String ffProfessor = "555.555.555-55";
	private String ffJrProfessor = "666.666.666-66";
	private String ffMeProfessor = "777.777.777-77";
	private String cpfApagado = "999.999.999-99";

	public IpirangaImpostoSimplesBRTest() throws Exception {
		ipiranga = new IpirangaImpostoSimplesBR();
		ipiranga.adicionarTaxista("Pedro Pedreiro", ppTaxista, 7000, 1500);
		ipiranga.adicionarTaxista("Pedro Pedreiro Jr", ppJrTaxista, 0, 10);
		ipiranga.adicionarCaminhoneiro("Renato Rocha", rrCaminhoneiro, 15000, 200);
		ipiranga.adicionarCaminhoneiro("Renato Rocha Jr", rrJrCaminhoneiro, 0, 10);
		ipiranga.adicionarProfessor("Francisco Feijão", ffProfessor, 5000, 100000);
		ipiranga.adicionarProfessor("Francisco Feijão Jr", ffJrProfessor, 0, 880);
		ipiranga.adicionarProfessor("Francisco Feijão Me", ffMeProfessor, 0, 4400);
	}

	@Test
	public void testeProva() throws Exception {
		testeNomesEBens();
		testeRemover();
		testeImpostos();
		testeLimiar();

		// testes extras: descomente para verificar sua implementacao.
		// testeOrdemImposto();
		// testeExtraException();
	}

	private void testeNomesEBens() throws Exception {
		Assert.assertEquals("[TAXISTA] Pedro Pedreiro, 111.111.111-11.", ipiranga.getString(ppTaxista));
		Assert.assertEquals("[TAXISTA] Pedro Pedreiro Jr, 222.222.222-22.", ipiranga.getString(ppJrTaxista));
		Assert.assertEquals("[CAMINHONEIRO] Renato Rocha, 333.333.333-33.", ipiranga.getString(rrCaminhoneiro));
		Assert.assertEquals("[CAMINHONEIRO] Renato Rocha Jr, 444.444.444-44.", ipiranga.getString(rrJrCaminhoneiro));
		Assert.assertEquals("[PROFESSOR] Francisco Feijão, 555.555.555-55.", ipiranga.getString(ffProfessor));
		Assert.assertEquals("[PROFESSOR] Francisco Feijão Jr, 666.666.666-66.", ipiranga.getString(ffJrProfessor));

		Assert.assertEquals(0.0, ipiranga.getBens(ppTaxista), 0.001);
		Assert.assertEquals(0.0, ipiranga.getBens(rrCaminhoneiro), 0.001);
		Assert.assertEquals(0.0, ipiranga.getBens(ffProfessor), 0.001);

		ipiranga.adicionarBem(ppTaxista, 0.01);
		Assert.assertEquals(0.01, ipiranga.getBens(ppTaxista), 0.01);
		ipiranga.adicionarBem(rrCaminhoneiro, 9.99);
		Assert.assertEquals(9.99, ipiranga.getBens(rrCaminhoneiro), 27);
		for (int i = 0; i < 10; i++) {
			ipiranga.adicionarBem(ffProfessor, 0.01);
		}
		Assert.assertEquals(0.1, ipiranga.getBens(ffProfessor), 0.01);
	}
	
	private void testeRemover() throws Exception {
		Assert.assertFalse(ipiranga.removerContribuinte(cpfApagado));
		ipiranga.adicionarProfessor("Serey Apagado", cpfApagado, 100, 100);
		Assert.assertTrue(ipiranga.removerContribuinte(cpfApagado));
		Assert.assertFalse(ipiranga.removerContribuinte(cpfApagado));
	}

	private void testeImpostos() throws Exception {
		Assert.assertEquals(5.0, ipiranga.getImposto(ppJrTaxista), 0.001);
		Assert.assertEquals(500.0, ipiranga.getImposto(rrJrCaminhoneiro), 0.001);
		Assert.assertEquals(44.0, ipiranga.getImposto(ffJrProfessor), 0.001);
		Assert.assertEquals(440.0, ipiranga.getImposto(ffMeProfessor), 0.001);
		Assert.assertEquals(680.0, ipiranga.getImposto(ppTaxista), 0.001);
		Assert.assertEquals(19350.0, ipiranga.getImposto(rrCaminhoneiro), 0.001);
		Assert.assertEquals(17500.0, ipiranga.getImposto(ffProfessor), 0.001);
	}

	private void testeLimiar() throws Exception {
		Set<String> acimaLimiar = ipiranga.getContribuintesAcimaLimiar();
		Assert.assertEquals(0, acimaLimiar.size());

		ipiranga.adicionarBem(ppJrTaxista, 100000);
		ipiranga.adicionarBem(rrJrCaminhoneiro, 150000);
		ipiranga.adicionarBem(ffJrProfessor, 300000);

		acimaLimiar = ipiranga.getContribuintesAcimaLimiar();
		Assert.assertEquals(0, acimaLimiar.size());

		ipiranga.adicionarBem(ppJrTaxista, 0.01);
		ipiranga.adicionarBem(rrJrCaminhoneiro, 0.01);
		ipiranga.adicionarBem(ffJrProfessor, 0.01);

		acimaLimiar = ipiranga.getContribuintesAcimaLimiar();
		Assert.assertEquals(3, acimaLimiar.size());
		Assert.assertTrue(acimaLimiar.contains(ppJrTaxista));
		Assert.assertTrue(acimaLimiar.contains(rrJrCaminhoneiro));
		Assert.assertTrue(acimaLimiar.contains(ffJrProfessor));
	}

	/*private void testeOrdemImposto() throws Exception {
		List<String> ordenadosPorImposto = ipiranga.getContribuintesOrdenadosPorImposto();
		String[] expected = { ppJrTaxista, ffJrProfessor, ffMeProfessor, rrJrCaminhoneiro, ppTaxista, ffProfessor,
				rrCaminhoneiro };
		Assert.assertArrayEquals(expected, ordenadosPorImposto.toArray());
	}
*/
	private void testeExtraException() {
		try {
			ipiranga.adicionarTaxista(null, "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarTaxista("", "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarTaxista("Pedro Pedreiro", null, 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("CPF inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarTaxista("Pedro Pedreiro", "", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("CPF inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarTaxista(null, "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarTaxista("", "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}

		try {
			ipiranga.adicionarCaminhoneiro(null, "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarCaminhoneiro("", "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarCaminhoneiro("Pedro Pedreiro", null, 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("CPF inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarCaminhoneiro("Pedro Pedreiro", "", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("CPF inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarCaminhoneiro(null, "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarCaminhoneiro("", "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}

		try {
			ipiranga.adicionarProfessor(null, "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarProfessor("", "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarProfessor("Pedro Pedreiro", null, 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("CPF inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarProfessor("Pedro Pedreiro", "", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("CPF inválido.", e.getMessage());
		}
		try {
			ipiranga.adicionarProfessor(null, "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try {
			
			ipiranga.adicionarProfessor("", "111.111.111-11", 7000, 1500);
			Assert.fail("Era esperado uma exceção.");
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
	}
}


