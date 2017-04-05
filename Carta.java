/**
 * Classe que se comporta como uma carta
 * Possui metodos de retorno do valor e do naipe da carta
 * e um toString
 * @author edson toma - 9791305
 */
public class Carta {
	private int valor;
	private int naipe;
/**
 * Construtor da carta
 * Inicializa a carta com um valor (2 a 14) e um naipe (0 a 3)
 * @param valor - valor da carta (2-10, J(11), Q(12), K(13), A(14))
 * @param naipe - valor do naipe (ouros(0), espadas(1), copas(2), paus(3))
 */
	public Carta(int valor, int naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
/**
 * Metodo que retorna o valor da carta
 * Sendo que de 2 a 10 sao os mesmos valores
 * e de 11 a 14, respectivamente, J, Q, K, A
 */
	public int getValor() {
		return valor;
	}
/**
 * Metodo que retorna o valor do naipe
 * Inteiros de 0 a 3 que representam, respectivamente, ouros, espadas, copas e paus
 */
	public int getNaipe() {
		return naipe;
	}
/**
 * Metodo auxiliar para toString
 * Converte o int em string para impressao da carta
 */
	private String valorToString() {
		if (valor >= 2 && valor <= 10)
			return Integer.toString(valor);
		else if (valor == 11)
			return "J";
		else if (valor == 12)
			return "Q";
		else if (valor == 13)
			return "K";
		else if (valor == 14)
			return "A";
		else
			return "";
	}

@Override
/**
 * Metodo que retorna uma string com os caracteres que formam determinada carta
 */
	public String toString() {
		String carta = "", s0 = ".------.\n", s1 = "*------*\n";
		
		for (int i = 0; i < 6; i++) {
			if (i == 0)
				carta += s0;
			else if (i == 5)
				carta += s1;
			else if (i == 1) {
				carta += "|" + valorToString();
				if (valor != 10)
					carta += ' ';
				if (naipe == 0)
					carta += "/\\  |\n";
				else if(naipe == 1)
					carta += ".   |\n";
				else if (naipe == 2)
					carta += "    |\n";
				else if (naipe == 3)
					carta += "_   |\n";
			}
			if (i == 2) {
				if (naipe == 0)
					carta += "| /  \\ |\n| \\  / |\n";
				else if(naipe == 1)
					carta += "| / \\  |\n|(_,_) |\n";
				else if (naipe == 2)
					carta += "|( \\/ )|\n| \\  / |\n";
				else if (naipe == 3)
					carta += "| ( )  |\n|(_x_) |\n";
			}
			else if (i == 4) {
				if (naipe == 0)
					carta += "|  \\/";
				else if(naipe == 1)
					carta += "|  I ";
				else if (naipe == 2)
					carta += "|  \\/";
				else if (naipe == 3)
					carta += "|  Y ";
				if (valor != 10)
					carta += ' ';
				carta += valorToString() + "|\n";
			}
		}
		
		return carta;
	}
/**
 * Auxiliar de debug
 */
	public static void main(String[] args) {
		for (int i = 2; i < 15; i++) {
			for(int j = 0; j < 4; j++) {
				Carta carta = new Carta(i, j);
				System.out.println(carta);
			}
		}
	}
}

/**
* Formato basico das cartas:
* 
* 	.------.
*	|N     |
*	|( \/ )| 
*	| \  / |
*	|  \/ N|
*	*------*
*	
*	.------.
*	|N /\  |
*	| /  \ | 
*	| \  / |
*	|  \/ N|
*	*------*
*	
*	.------.
*	|N  .  |
*	|  / \ | 
*	| (_,_)|
*	|   I N|
*	*------*
*	
*	.------.
*	|N  _  |
*	|  ( ) | 
*	| (_x_)|
*	|   Y N|
*	*------*
*/
