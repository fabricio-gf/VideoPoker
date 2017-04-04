
public class Mao {
   private Carta cartas[];
     
   public Mao(int n) {
	   cartas = new Carta[n];
   }
   
  public void setCartas(Carta[] cartas) {
	  if (cartas.length == this.cartas.length)
		  this.cartas = cartas;
   }

public void trocarCartas(String s) throws IllegalArgumentException {
	   if (s != null && !s.isEmpty()) {   //se a string estiver vazia presume-se que nenhuma carta sera trocada!
			String[] numeros = s.split("\\s");
				
			for (int i = 0; i < numeros.length; i++) {   //as cartas sao representados de 1 para cima
				if (Integer.parseInt(numeros[i]) - 1 < cartas.length && Integer.parseInt(numeros[i]) > 0) {//entre 0 e n
					//fazer a troca
					//utilizar cartas[Integer.parseInt(numeros[i])-1]
					//porque os valores das posicoes comecam em 1, mas o array em 0
				}
				else throw new IllegalArgumentException("Posicçao inválida!");
			}
		}
   }
@Override
	public String toString(){
		return "";
	}
}
