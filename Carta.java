
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
		switch(valor) {
			case 0:
				return "A";
			case 1:
				return "2";
			case 2:
				return "3";
			case 3:
				return "4";
			case 4:
				return "5";
			case 5:
				return "6";
			case 6:
				return "7";
			case 7:
				return "8";
			case 8:
				return "9";
			case 9:
				return "10";
			case 10:
				return "Q";
			case 11:
				return "J";
			case 12:
				return "K";
			default:
				return "";
		}
	}
	
	public String toString() {
		String carta = "", s0 = ".------.\n", s1 = "`------´\n";
		
		for (int i = 0; i < 6; i++) {
			if (i == 0)
				carta += s0;
			else if (i == 5)
				carta += s1;
			else if (i == 1) {
				carta += "|" + valorToString();
				if (naipe == 0)
					carta += " /\\  |\n";
				else if(naipe == 1)
					carta += "  .  |\n";
				else if (naipe == 2)
					carta += "_  _ |\n";
				else if (naipe == 3)
					carta += "  _  |\n";
			}
			if (i == 2) {
				if (naipe == 0)
					carta += "| /  \\ |\n| \\  / |\n";
				else if(naipe == 1)
					carta += "|  / \\ |\n| (_,_)|\n";
				else if (naipe == 2)
					carta += "|( \\/ )|\n| \\  / |\n";
				else if (naipe == 3)
					carta += "|  ( ) |\n| (_x_)|\n";
			}
			else if (i == 4) {
				if (naipe == 0)
					carta += "|  \\/ " + valorToString() + "|\n";
				else if(naipe == 1)
					carta += "|   I " + valorToString() + "|\n";
				else if (naipe == 2)
					carta += "|  \\/ " + valorToString() + "|\n";
				else if (naipe == 3)
					carta += "|   Y " + valorToString() + "|\n";
			}
		}
		
		return carta;
	}


	public static void main(String[] args) {
		for (int i = 0; i < 13; i++) {
			Carta carta = new Carta(i, i%4);
			System.out.println(carta);
		}
	}
}

/**
 	.------.
	|N_  _ |
	|( \/ )| 
	| \  / |
	|  \/ N|
	`------´
	
	.------.
	|N /\  |
	| /  \ | 
	| \  / |
	|  \/ N|
	`------´
	
	.------.
	|N  .  |
	|  / \ | 
	| (_,_)|
	|   I N|
	`------´
	
	.------.
	|N  _  |
	|  ( ) | 
	| (_x_)|
	|   Y N|
	`------´
*/