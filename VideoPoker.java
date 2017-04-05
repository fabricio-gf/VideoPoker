public class VideoPoker {

	public static void main(String[] args) {
		Baralho b = new Baralho();
		Mao m = new Mao();
		Pontuacao p = new Pontuacao(200);//200 creditos iniciais
		int aposta = 0;
		boolean work;
		
		while (true) {//rodadas
			work = false;
			while(!work) {
				try {
					System.out.println("Digite o valor da aposta:\n");
					aposta = EntradaTeclado.leInt();
					if (aposta <= p.getCreditos() && aposta > 0)
						work = true;
					else {
						work = false;
						System.out.println("Creditos insuficientes e/ou aposta invalida!\n");
					}
				} catch (Exception e) {
					System.out.println("Algo deu errado! Tente novamente...\n");
					work = false;
				}
			}
		
			b.embaralhar();
		    b.darCartas(m);
		    System.out.println("Suas cartas:\n" + m.toString());
		    
		    for (int i = 0; i < 2; i++) {
		    	work = false;
		    	while (!work) {
		    		try{
		    			System.out.println("Digite quais cartas trocar:\n");
		    			m.trocarCartas(EntradaTeclado.leString(), b);
		    			System.out.println("Suas cartas:\n" + m.toString());
		    			work = true;
		    		} catch (Exception e) {
		    			System.out.println("Algo deu errado! Tente novamente...\n");
		    			work = false;
		    		}
		    	}
		    }
		    System.out.printf("Creditos ganhos nesta rodada: %d\n", p.calculaRodada(aposta, m));
		    System.out.printf("Creditos totais: %d\n", p.getCreditos());
		    
		    if (p.getCreditos() == 0)//sem creditos sem rasao para continuar!
		    	break;
		   
		    work = false;
		    String s = "";
			while(!work) {
				try {
					System.out.println("Deseja continuar? Y/n\n");
					s = EntradaTeclado.leString();
					work = true;
				} catch (Exception e) {
					System.out.println("Algo deu errado! Tente novamente...\n");
					work = false;
				}
			}
		    s = s.toLowerCase();
		    if (s.equals("n")) break;//nao deseja continuar...
		}
		if (p.getCreditos() > 0)
			System.out.printf("Creditos finais: %d\n", p.getCreditos());
		else
			System.out.println("Seus creditos acabaram e voce foi expulso!\n");
	}
}
