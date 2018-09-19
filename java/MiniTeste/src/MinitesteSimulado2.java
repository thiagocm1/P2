import java.util.Scanner;
public class MinitesteSimulado2 {
	public static void main(String[] args){
		double[] numeros = new double[5];
		int i, j;
		double Numeros, calculaMedia,leArrayNumeros, Media;
		Scanner input = new Scanner(System.in);
		System.out.println("Informando os numeros reais ...");
		for (i = 0; i < 5; i++){
			Numeros = input.nextDouble();
			numeros[i] = Numeros;}
		Media = 0.0;
		for (j = 0; j < 5; j++){
			Media += numeros[j];
		}
		calculaMedia = (Media)/5;
		System.out.println("Media aritimetica: " + calculaMedia);
	}
}
