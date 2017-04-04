
public class Carta {
	private int valor;
	private int naipe;
	
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
	
	private String valorToString() {
		if (valor >= 2 && valor <= 10)
			return Integer.toString(valor);
		else if (valor == 11)
			return "Q";
		else if (valor == 12)
			return "J";
		else if (valor == 13)
			return "K";
		else if (valor == 14)
			return "A";
		else
			return "";
	}

@Override
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
 	.------.
	|N_  _ |
	|( \/ )| 
	| \  / |
	|  \/ N|
	`------Â´
	
	.------.
	|N /\  |
	| /  \ | 
	| \  / |
	|  \/ N|
	`------Â´
	
	.------.
	|N  .  |
	|  / \ | 
	| (_,_)|
	|   I N|
	`------Â´
	
	.------.
	|N  _  |
	|  ( ) | 
	| (_x_)|
	|   Y N|
	`------Â´
*/
