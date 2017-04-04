
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
				if (Integer.parseInt(numeros[i]) - 1 < cartas.length && Integer.parseInt(numeros[i]) > 0) {//entre 0 e length
					troca = new Carta[1];

					b.trocarCartas(troca);
					cartas[Integer.parseInt(numeros[i]) - 1] = troca[0];
/*
 *utiliza cartas[Integer.parseInt(numeros[i])-1]
 *porque os valores das posicoes comecam em 1, mas o array em 0
*/
				}
				else throw new IllegalArgumentException("Posic√ßao inv√°lida!");
			}
		}
	}
@Override
	public String toString(){
        String ret = "";
        int begin, end = 0;

        //LaÁo que unir· as strings das cartas do vetor
        for(int i = 0; i < 6; i++){ //Cada carta ocupa 6 linhas no console
            begin = end;
            end = cartas[0].toString().indexOf("\n", end+1);

            for(int j = 0; j < cartas.length; j++){ //LaÁo percorrer· todas as cartas do vetor
                ret += cartas[j].toString().substring(begin, end); //ConcatenaÁ„o de cada linha das cartas
                ret += "\t"; //Separador das cartas
            }
            end++;
            ret += "\n";
        }

        return ret;
	}

	public static void main(String[] args){
	    Mao mao = new Mao();
	    Baralho b = new Baralho();

	    b.embaralhar();
	    b.darCartas(mao);

	    System.out.println(mao.toString());

    }
}
