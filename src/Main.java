import formulario.Formulario;
import jogo.Territorio;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Formulario form = new Formulario("Formulário");
        Territorio area;
        String nomeArquivo = "Jogador.jgd";

        while (true) {
            int janelaX = form.getX();
            int janelaY = form.getY();
            int ritmoJogo = form.getRitmoJogo();
            int quantidadeInimigos = form.getQuantidadeObjetos();
            int pontuacaoMaxima = form.getPontuacaoMaxima();
            String nomeJogador = form.getNomeJogador();

            if (form.validacao) {
                area = new Territorio(nomeJogador, janelaX, janelaY, quantidadeInimigos, pontuacaoMaxima, ritmoJogo);
                break;
            } else {
                System.out.println();
                area = new Territorio(nomeJogador, janelaX, janelaY, quantidadeInimigos, pontuacaoMaxima, ritmoJogo);
                break;
            }
        }
        area.jogar();
    }
}
