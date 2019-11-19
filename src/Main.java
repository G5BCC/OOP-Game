import exceptions.ExcecaoCamposNaoPreenchidos;
import formulario.Formulario;
import jogo.Territorio;

public class Main {
    public static void main(String[] args) {
        Formulario form = new Formulario("Formulário");
        Territorio territorio;

        int janelaX = form.getX();
        int janelaY = form.getY();
        int ritmoJogo = form.getRitmoJogo();
        int quantidadeInimigos = form.getQuantidadeObjetos();
        int pontuacaoMaxima = form.getPontuacaoMaxima();
        String nomeJogador = form.getNomeJogador();

        if(form.getFlagCamposOK()){
            territorio = new Territorio("Jogo de " + nomeJogador, janelaX, janelaY, pontuacaoMaxima, quantidadeInimigos, ritmoJogo);
            territorio.jogar();
        }
    }
}
