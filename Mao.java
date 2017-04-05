/**
 * Classe criada para se comportar como uma mao (conjunto de cartas)
 * Possui metodos para determinar as cartas da mao e para retornar as cartas da mao
 * Alem de metodos para trocar determinadas cartas e um toString
 * @author edson toma - 9791305 
 */
public class Mao {
   private Carta cartas[];
/**
 * Metodo que recebe um array de cartas que sera utilizado como as cartas da mao
 * @param cartas - array de cartas (Carta[])
 */
   public void setCartas(Carta[] cartas) {
	   this.cartas = cartas;
   }
  /**
   * Metodo que retorna as cartas da mao
   */
   public Carta[] getCartas() {
	   return cartas;
   }
/**
 * Metodo que troca determinadas cartas a partir de uma string de chars que contem quais cartas serao trocadas
 * A string eh subdividida pelos espaços e, em seguida, converte-se cada substring em um int
 * Cada int representa qual posicao sera trocada
 * @param s - String que contem quais cartas serao trocadas
 * @param b - Baralho do jogo
 * @throws IllegalArgumentException - Se a posicao digitada nao for valida
 */
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
 *utilizar cartas[Integer.parseInt(numeros[i])-1]
 *porque os valores das posicoes comecam em 1, mas o array em 0
*/
				}
				else throw new IllegalArgumentException("Posicao invalida!");
			}
		}
	}
@Override
/**
 * Metodo que retorna uma string com os caracteres que formam um conjunto de cartas (a mao)
 */
	public String toString(){
        String ret = "";
        int begin, end = 0;
        for (int i = 0;i < cartas.length; i++) {
        	ret += "    " + Integer.toString(i+1) + "   \t";
        }
        ret += "\n";
        //Laço que unirá as strings das cartas do vetor
        for(int i = 0; i < 6; i++){ //Cada carta ocupa 6 linhas no console
            begin = end;
            end = cartas[0].toString().indexOf("\n", end+1);

            for(int j = 0; j < cartas.length; j++){ //Laço percorrerá todas as cartas do vetor
                ret += cartas[j].toString().substring(begin, end); //Concatenação de cada linha das cartas
                ret += "\t"; //Separador das cartas
            }
            end++;
            ret += "\n";
        }

        return ret;
	}
/**
 * Auxiliar de debug
 */
	public static void main(String[] args) throws Exception{
	    Mao mao = new Mao();
	    Baralho b = new Baralho();

	    b.embaralhar();
	    b.darCartas(mao);

	    System.out.println(mao.toString());
	    System.out.println("Digite quais cartas trocar\n");
	    String s = EntradaTeclado.leString();
	    mao.trocarCartas(s, b);
	    System.out.println(mao.toString());
    }
}
