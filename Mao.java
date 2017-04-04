
public class Mao {
   private Carta cartas[];

  public void setCartas(Carta[] cartas) {
		  this.cartas = cartas;
   }

public void trocarCartas(String s, Baralho b) throws IllegalArgumentException {
      Carta troca[];
	   if (s != null && !s.isEmpty()) {   //se a string estiver vazia presume-se que nenhuma carta sera trocada!
			String[] numeros = s.split("\\s");
				
			for (int i = 0; i < numeros.length; i++) {   //as cartas sao representados de 1 para cima
				if (Integer.parseInt(numeros[i]) - 1 < cartas.length && Integer.parseInt(numeros[i]) > 0) {//entre 0 e n
					troca = new Carta[numeros.length];

					b.trocarCartas(troca);
                    for(int j = 0; j < troca.length; j++){
                        cartas[Integer.parseInt(numeros[i]) - 1] = troca[j];
                        /*
                        *utiliza cartas[Integer.parseInt(numeros[i])-1]
                        *porque os valores das posicoes comecam em 1, mas o array em 0
                        */
                    }
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
