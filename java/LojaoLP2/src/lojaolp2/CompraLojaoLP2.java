package lojaolp2;
import java.util.Scanner;
public class CompraLojaoLP2 {
	public static void main(String[] args){
	int quantidade, i,j, quantidadeProduto, totalProd, Quantidade;
	double valor, totalGasto, Percentagem;
	String produto;
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Bem vindo ao lojão LP2!");
	
	System.out.printf("Digite a quantidade de produtos diferentes: ");
	quantidade = input.nextInt();
	
	int[] numProdutos = new int[quantidade];
	
	String[] produtos = new String[quantidade];
	
	System.out.println("-- Cadastro de Produtos --");
	
	totalGasto = 0.0;
	totalProd = 0;
	
	for (i = 0; i < quantidade; i++){
		System.out.printf("Nome do produto %d: ",(i+1));
		
		input.nextLine();
		
		produto = input.nextLine();
		
		produtos[i] = produto;
		
		System.out.printf("Quantidade de %s: ", produtos[i]);
		Quantidade = input.nextInt();
		
		totalProd += Quantidade;
		
		numProdutos[i] = Quantidade;
		
		}
		
	System.out.println( "-- Cadastro Concluído -- " );
	
	System.out.println( "A sua compra foi: " );
	
	for (int k = 0; k < quantidade; k++){
		Percentagem =  ((numProdutos[k]*100)/totalGasto);
		System.out.printf("%f'",Percentagem);
	}
	System.out.printf("Total de produtos: %d\n", totalProd);
	
	totalGasto = totalProd * 1.99;
	
	System.out.printf("Total gasto: R$ %.2f\n",totalGasto);
	
	System.out.println("-- Fim da execução --");
	}
	}

