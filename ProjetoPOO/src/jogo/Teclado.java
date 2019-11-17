package jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
    private Jogador jogador;

    public Teclado(Jogador jogador) {
        this.jogador = jogador;
    }

    public void keyTyped(KeyEvent tecla) {
    }

    public void keyPressed(KeyEvent tecla) {
        jogador.keyPressed(tecla);
    }

    public void keyReleased(KeyEvent tecla) {
        jogador.keyReleased(tecla);
    }
}