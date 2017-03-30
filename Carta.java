
public class Carta {
	private int valor;
	private int naipe; //Ouros = 0, Espada = 1, Copas = 2, Paus = 3
	
	public Carta(int valor, int naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
	
	
	
	public int getValor() {
		return valor;
	}



	public int getNaipe() {
		return naipe;
	}



	public static void main(String[] args) {
		System.out.println("♠ ♥ ♦ ♣\n");

	}
		
}
