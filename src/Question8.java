public class Question8 {

	public static void main(String[] args) {
//		System.out.println("Valor de A: 10256 | Valor de B: 512: Valor de C: " + calcABC(10256, 512));
		System.out.println("Valor de A: 102 | Valor de B: 512: Valor de C: " + calcABC(102, 512));
	}
/*	
	8 - Dados dois numeros inteiros A e B, crie um terceiro inteiro C seguindo as seguintes
	regras:
	- O primeiro número de C é o primeiro número de A;
	- O segundo número de C é o primeiro número de B;
	- O terceiro número de C é o segundo número de A;
	- O quarto número de C é o segundo número de B;
	Assim sucessivamente...
	- Caso os números de A ou B sejam de tamanhos diferentes, completar C com o restante
	dos números do inteiro maior. Ex: A = 10256, B = 512, C deve ser 15012256.
	- Caso C seja maior que 1.000.000, retornar -1
*/	
	public static int calcABC(Integer a, Integer b) {
		String c= "";
		if (a == null) {
			System.out.println("Informe um valor para a");
			return 0;
		} else if (b == null) {
			System.out.println("Informe um valor para b");
			return 0;
		} else {
			int tamA = a.toString().length();
			int tamB = b.toString().length();
			int tam = tamA;
			if (tamB > tamA) {
				tam = tamB;
			}
			for (int i = 0; i<tam; i++) {
				if (i < tamA) {
					c = c + a.toString().substring(i, i+1);
				} else {
					c = c + b.toString().substring(i);
					break;
				}
				if (i < tamB) {
					c = c + b.toString().substring(i, i+1);
				} else {
					c = c + a.toString().substring(i+1);
					break;
				}
			}
			
		}
		if (Long.parseLong(c) > 1000000) {
			return -1;
		} else {
			return Integer.parseInt(c);
		}
	}
	
}
