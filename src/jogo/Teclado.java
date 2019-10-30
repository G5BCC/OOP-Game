package jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    private Jogador jogador;

    // Método construtor
    public Teclado(Jogador jogador) {
        this.jogador = jogador;
    }

    public void keyTyped(KeyEvent tecla) {
    }

    // Leitura do teclado
    public void keyPressed(KeyEvent tecla) {
        jogador.keyPressed(tecla);
    }

    public void keyReleased(KeyEvent tecla) {
    }
}
