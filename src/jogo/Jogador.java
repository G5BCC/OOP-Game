package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Jogador extends JComponent {
    // Atributos
    private Territorio territorio;
    private Color cor;
    private static final Random numeroAleatorio = new Random();

    private int x = 450;
    private int y = numeroAleatorio.nextInt(100 + 1);
    private int altura = 30;
    private int largura = 30;
    public int diametro = largura;

    // Construtor
    public Jogador(Color cor, Territorio territorio) {
        this.cor = cor;
        this.territorio = territorio;
        this.x = territorio.larguraJanela + diametro;
    }

    // Método para desenhar o objeto
    public void paint(Graphics g) {
        Graphics2D desenho = (Graphics2D) g;

        desenho.setColor(cor);
        desenho.fillOval(x, y, largura, altura);
    }

    // Método para ler teclas
    public void keyPressed(KeyEvent tecla) {
        switch (tecla.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                x -= 5;
                break;
            }
            case KeyEvent.VK_RIGHT: {
                x += 5;
                break;
            }
            case KeyEvent.VK_UP: {
                y -= 5;
                break;
            }
            case KeyEvent.VK_DOWN: {
                y += 5;
                break;
            }
        }
    }

    // Posição inicial para o jogador principal
    public void posicaoInicial(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Movimentação dos inimigos
    public void moverX(int unidades) {
        this.x -= unidades;
    }

    public int posicaoX() {
        return x;
    }

    // Nova posição no eixo Y dos inimigos após desaparecerem na janela
    public void novaPosicaoY() {
        this.y = numeroAleatorio.nextInt(territorio.alturaJanela + 1);
    }
}
