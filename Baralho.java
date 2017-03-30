
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

	public Carta[] darCartas(int n) throws Exception {
		Carta ret[] = new Carta[n];

		for (int i = 0; i < n; i++) {
			if (pos >= 52)
				throw new Exception("Baralho vazio!");

			ret[i] = cartas[pos];
			pos++;
		}

		return ret;
	}
	
	public void trocarCartas(Carta[] cartas){
		for(int i = 0; i < cartas.length; i++){
			cartas[i] = this.cartas[pos];
			pos++;
		}
	}

	public static void main(String[] args) throws Exception {
		Baralho b = new Baralho();
		Carta cartas[] = b.darCartas(52);

		for (int i = 0; i < 52; i++) {
			System.out.println(cartas[i].getValor() + " " + cartas[i].getNaipe());
		}

		b.embaralhar();
		b.trocarCartas(cartas);

		for (int i = 0; i < 52; i++) {
			System.out.println(cartas[i].getValor() + " " + cartas[i].getNaipe());
		}

	}

}
