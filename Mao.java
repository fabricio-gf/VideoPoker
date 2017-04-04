
public class Mao {
   private Carta cartas[];
   private Baralho baralho = new Baralho();
   
   public Mao(int n) {
	   cartas = new Carta[n];
   }
   
   public void gerarMao() throws Exception {
	   baralho.embaralhar();
	   cartas = baralho.darCartas(cartas.length);
   }
   
   public void trocarCartas(String s) throws IllegalArgumentException {
	   if (s != null && !s.isEmpty()) {   //se a string estiver vazia presume-se que nenhuma carta sera trocada!
			String[] numeros = s.split("\\s");
				
			for (int i = 0; i < numeros.length; i++) {   //as cartas sao representados de 1 para cima
				if (Integer.parseInt(numeros[i]) - 1 < cartas.length && Integer.parseInt(numeros[i]) > 0)
					cartas[Integer.parseInt(numeros[i])-1] ;//troca a carta da pos   
				//e as posicoes a partir de de 0, por isso o -1
				else throw new IllegalArgumentException("Posicçao inválida!");
			}
		}
   }
}
