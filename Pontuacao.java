/**
 * Classe usada para administrar a pontuacao do jogo,
 * calculando os resultados das apostas de cada rodada
 * @author Bruno Flavio 9791330
 */
public class Pontuacao {
    private int creditos; //Armazena os creditos totais do jogador

    private int cartas[] = new int[15]; //Contador de cartas, usado para definir a pontuacao da rodada
    private boolean flush; //flag auxiliar se ha flush na mao em uma rodada

    /**
     * Construtor da classe
     * @param creditos - Inteiro com quantos creditos o jogador inicia
     */
    public Pontuacao(int creditos){
        this.creditos = creditos;
    }

    public int getCreditos(){
        return creditos;
    }

    /**
     * Metodo auxiliar que zera o contador de cartas
     */
    private void zerarCartas(){
        for(int i = 0; i < cartas.length; i++){
            cartas[i] = 0;
        }
    }

    /**
     * Metodo auxiliar que conta as cartas e tambem verifica se a mao possui flush
     * @param cartas
     */
    private void analizarMao(Carta[] cartas){
        zerarCartas();
        flush = true;
        int naipe = cartas[0].getNaipe();

        //Laço que conta as cartas
        for(int i = 0; i < cartas.length; i++){
            this.cartas[cartas[i].getValor()]++;
            if(cartas[i].getNaipe() != naipe) flush = false;
        }
    }

    /**
     * Metodo que calcula o resultado da aposta daquela rodada e atualiza os creditos
     * @param aposta - Inteiro com a quantidade creditos que foi apostado naquela rodada
     * @param mao - Mao daquela rodada
     * @return Os creditos ganhados na rodada
     * @throws IllegalArgumentException - Se a aposta for maior que o saldo de creditos
     */
    public int calculaRodada(int aposta, Mao mao) throws IllegalArgumentException{
        int par = 0, trinca = 0, quadra = 0, seq = 0; //Contadores de pares trincas, quadras e cartas em sequencia
        int anterior = 0; //Variavel auxiliar que armazena a ultima carta lida no laço
        boolean primeira = true;

        if(creditos < aposta) throw new IllegalArgumentException("Voce nao tem creditos suficientes!");
        creditos -= aposta;

        analizarMao(mao.getCartas());

        //Laço que verifica quantos pares, trincas, quadras e sequencias existem naquela mao
        for(int i = 2; i < cartas.length; i++){
            if(cartas[i] == 2) par++;
            else if(cartas[i] == 3) trinca++;
            else if(cartas[i] == 4) quadra++;

            if(cartas[i] > 0 && (i == anterior+1 || primeira)) { //Entra no if se for a primeira carta[i] > 0 ou se a carta for sequencia da anterior
                seq++;
                anterior = i;
                primeira = false;
            }
        }

        if(seq == 5 && flush && cartas[14] == 1){ //Royal Straight Flush (cartas[14] => As)
            aposta *= 200;
        }
        else if(seq == 5 && flush) //Straight Flush
            aposta *= 100;

        else if(quadra > 0) //Quadra
            aposta *= 50;

        else if(trinca == 1 && par == 1) //Full Hand
            aposta *= 20;

        else if(flush) //Flush
            aposta *= 10;

        else if(seq == 5) //Straigh
            aposta *= 5;

        else if(trinca == 1) //Trinca
            aposta *= 2;

        else if(par == 2); //2 pares

        else
            aposta = 0;

        creditos += aposta; //Atualiza os creditos
        return aposta;
    }

    /**
     * Metodo usado apenas para Debug
     * @param args - Sem utilidade
     */
    public static void main(String[] args){
        Pontuacao p = new Pontuacao(100);
        Mao m = new Mao();
        Carta[] cartas = {new Carta(2, 1), new Carta (4, 1), new Carta(3, 1), new Carta(6, 3), new Carta(5, 0)};

        m.setCartas(cartas);
        System.out.println(m.toString());
        System.out.println(p.calculaRodada(1, m));
    }

}
