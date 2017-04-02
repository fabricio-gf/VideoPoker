/**
 * Classe desenhada para se comportar como um baralho de 52 cartas.
 * Ela implementa métodos para distribuir cartas, embaralhar e trocar cartas com o baralho
 * @author Bruno Flávio - 9791330
 */
public class Baralho {
	Carta cartas[] = new Carta[52];
	int pos = 0; // Marca quais posições do baralho ja foram entregues

	/**
	 * Construtor do Baralho, inicializa todas as cartas do baralho em sequencia
	 * de 2 a Ás e de ouros à paus
	 */
	public Baralho() {
		int i = 0;

		for (int naipe = 0; naipe < 4; naipe++) {
			for (int valor = 2; valor <= 14; valor++) {
				cartas[i] = new Carta(valor, naipe);
				i++;
			}
		}

	}

	/**
	 * Método que reinicia o baralho (recolhe as cartas) e embaralha
	 */
	public void embaralhar() {
		Random r = new Random();
		pos = 0;

		for (int i = 0; i < 52; i++) {
			int rpos = r.getIntRand(52);
			// Swap
			Carta aux = cartas[rpos];
			cartas[rpos] = cartas[i];
			cartas[i] = aux;
		}
	}

	/**
	 * Método que distribui as cartas do baralho
	 * @param n - Inteiro com o número de cartas a ser distribuido
	 * @return Carta[] - Vetor com as cartas distribuidas
	 * @throws IllegalArgumentException - Se o parametro n for maior que a capacidade atual do baralho
	 */
	public Carta[] darCartas(int n) throws Exception {
		Carta ret[] = new Carta[n];

		if(n > 52 - pos) throw new IllegalArgumentException("O baralho não possui cartas suficientes");

		for (int i = 0; i < n; i++) {
			ret[i] = cartas[pos];
			pos++;
		}

		return ret;
	}

	/**
	 * Método que recolhe ao baralho um vetor de cartas e as trocam com novas cartas
	 * @param cartas - Vetor do tipo Carta, que contém as cartas a serem trocadas
	 */
	public void trocarCartas(Carta[] cartas){
		for(int i = 0; i < cartas.length; i++){
			cartas[i] = this.cartas[pos];
			pos++;
		}
	}

	/**
	 * Método usado somente para debug
	 * @param args - Sem utilidade
	 */
	public static void main(String[] args) throws Exception {
		Baralho b = new Baralho();
		Carta cartas[] = b.darCartas(52);

		for (int i = 0; i < 52; i++) {
			System.out.println(cartas[i].getValor() + " " + cartas[i].getNaipe());
			System.out.println(cartas[i].toString());
		}

		b.embaralhar();
		b.trocarCartas(cartas);

		for (int i = 0; i < 52; i++) {
			System.out.println(cartas[i].getValor() + " " + cartas[i].getNaipe());
		}

	}

}
