import formulario.Formulario;
import jogo.Territorio;

public class Main {
    public static void main(String[] args) {
        Formulario form = new Formulario("Formulário");
        Territorio territorio;

        System.out.println("Validação");
        while (true) {
            int janelaX = form.getX();
            int janelaY = form.getY();
            int ritmoJogo = form.getRitmoJogo();
            int quantidadeInimigos = form.getQuantidadeObjetos();
            int pontuacaoMaxima = form.getPontuacaoMaxima();
            String nomeJogador = form.getNomeJogador();

            if (form.validacao) {
                territorio = new Territorio(nomeJogador, janelaX, janelaY, quantidadeInimigos, pontuacaoMaxima, ritmoJogo);
                System.out.println("OK");
                break;
            }
            else {
                System.out.println("");
            }
        }
        territorio.jogar();
    }
}
