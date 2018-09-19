package prova1.copy;

public class Teste {
	private Pokemon starmie;
	private Pokemon pikachu;
	private Pokemon squirtle;
	private Pokemon articuno;
	private Treinador neto;
	private Treinador ash;

	@Before
	public void setup() throws Exception {
		starmie = new Pokemon("Starmie", 50, "Psiquico", 15);
		pikachu = new Pokemon("Pikachu", 30, "Eletrico", 10);
		squirtle = new Pokemon("Squirtle", 15, "Agua", 8);
		articuno = new Pokemon("Articuno", 50, "Gelo", 20);

		neto = new Treinador("Neto");
		ash = new Treinador("Ash");
	}

	@Test
	public void testeProva() throws Exception {
		testePasso1();
		testePasso2e3();
		testePasso4();
		testePasso5();
		
		//testes extras: descomente para verificar sua implementacao.
		//testeExtraException();
		//testeExtraMochila();
	}

	private void testePasso1() throws Exception {
		Pokemon starmieRaro = new Pokemon("Starmie", 50, "Psiquico", 18);

		Assert.assertEquals("Starmie", starmie.getNome());
		Assert.assertEquals("Psiquico", starmie.getTipo());
		Assert.assertEquals(50, starmie.getNivel());
		Assert.assertEquals(15, starmie.getAtaqueBase());
		Assert.assertEquals(750, starmie.getPoderAtaque());

		Assert.assertEquals("Starmie", starmieRaro.getNome());
		Assert.assertEquals("Psiquico", starmieRaro.getTipo());
		Assert.assertEquals(50, starmieRaro.getNivel());
		Assert.assertEquals(18, starmieRaro.getAtaqueBase());
		Assert.assertEquals(900, starmieRaro.getPoderAtaque());

		Assert.assertEquals(starmie, starmieRaro);
		Assert.assertNotEquals(starmie, pikachu);

		starmieRaro.ganhaNivel();
		Assert.assertEquals(51, starmieRaro.getNivel());
		Assert.assertNotEquals(starmie, starmieRaro);
	}

	private void testePasso2e3() throws Exception {
		Pokemon starmieRaro = new Pokemon("Starmie", 50, "Psiquico", 18);
		neto.captura(starmie);
		neto.captura(articuno);
		neto.captura(starmieRaro);

		// ------- Passo 2 -----------
		Assert.assertTrue(neto.jaCapturou("Starmie"));
		Assert.assertTrue(neto.jaCapturou("Articuno"));
		Assert.assertFalse(neto.jaCapturou("Pikachu"));
		Assert.assertFalse(neto.jaCapturou("Vileplume"));

}
