package reposicao;

public class MainTeste {

	public static void main(String[] args) throws Exception {
		// criando Idosos.
		Idoso emma = new Idoso("Emma Morano", 1.70, 61, 88);
		Idoso violet = new Idoso("Violet Brown", 1.74, 68, 77);
		Idoso nabi = new Idoso("Nabi Tajima", 1.69, 69, 96);
		Idoso chiyo = new Idoso("Chiyo Miyako", 1.80, 120, 72);
		Idoso toshie = new Idoso("Toshie Yorimitsu", 1.6, 48, 86);

		// Passo 2:
		System.out.println("========= Passo 2 =========");
		System.out.println("Deve ser true: "
				+ violet.adicionaExercicio("Apertar bolinha", 100, 40));
		System.out.println("Deve ser true: "
				+ violet.adicionaExercicio("Rebolar", 150, 80));

		System.out.println("Deve ser true: "
				+ emma.adicionaExercicio("Apertar bola com joelhos", 130, 50));
		System.out.println("Deve ser true: "
				+ emma.adicionaExercicio("Apertar bolinha", 100, 40));
		System.out.println("Deve ser false: "
				+ emma.adicionaExercicio("Apertar bola com joelhos", 130, 50));
		System.out.println("Deve ser true: "
				+ emma.adicionaExercicio("Alongar tronco", 100, 40));
		System.out.println("Deve ser true: "
				+ emma.adicionaExercicio("Alongar perna anterior", 110, 40));

		System.out.println("Deve ser true: "
				+ nabi.adicionaExercicio("Apertar bolinha", 100, 40));
		System.out.println("Deve ser true: "
				+ nabi.adicionaExercicio("Rebolar", 150, 80));

		System.out.println("Deve ser true: "
				+ chiyo.adicionaExercicio("Alongar perna anterior", 110, 40));
		System.out.println("Deve ser true: "
				+ chiyo.adicionaExercicio("Rebolar", 150, 80));
		
		// Passo3:
		System.out.println();
		System.out.println("========= Passo 3 =========");
		System.out.println("Deve ser 180: " + nabi.aguaPerdida(3));
		System.out.println("Deve ser 180: " + violet.aguaPerdida(3));
		System.out.println("Deve ser 127: " + emma.aguaPerdida(3));
		System.out.println("Deve ser 180: " + chiyo.aguaPerdida(3));
		System.out.println("Deve ser 0: " + toshie.aguaPerdida(3));
		//
		// Passo 4:
		System.out.println();
		System.out.println("========= Passo 4 =========");
		System.out.println(nabi);
		System.out.println(violet);
		System.out.println(emma);
		System.out.println(chiyo);
		System.out.println(toshie);

	// Passo 5:
		System.out.println();
		System.out.println("========= Passo 5 =========");

		emma.setPA(80, 120);
		nabi.setPA(50, 80);
		violet.setPA(new PressaoArterial(99, 150));
		chiyo.setPA(130, 190);

		System.out.println("Deve ser Pre-Hipertensao: " + emma.classificaPA());
		System.out.println("Deve ser Normal: " + nabi.classificaPA());
		System.out.println("Deve ser Hipertensao1: " + violet.classificaPA());
		System.out.println("Deve ser Hipertensao2: " + chiyo.classificaPA());

		// Passo 6:
		System.out.println();
		System.out.println("========= Passo 6 =========");
		System.out.println("Deve ser false:" + nabi.equals(emma));
		System.out.println("Deve ser true:" + nabi.equals(violet));
		System.out.println("Deve ser false:" + nabi.equals(chiyo));
		
	}
}
