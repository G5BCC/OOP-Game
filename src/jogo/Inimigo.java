package jogo;

import java.awt.*;
import java.util.Random;

public class Inimigo extends Personagem {
    private static final Random numeroAleatorio = new Random();

    public Inimigo(Color cor, Territorio territorio) {
        super(cor, territorio);
        this.x = territorio.larguraJanela + this.raio;
        setY();
    }

    public void paint(Graphics g) {
        Graphics2D desenho = (Graphics2D) g;

        desenho.setColor(this.cor);
        desenho.fillOval(this.x, this.y, this.largura, this.altura);
    }

    public void setX(int unidades) {
        this.x -= unidades;
    }

    public void setY() {
        int positionY = numeroAleatorio.nextInt(territorio.alturaJanela + 1);

        // Posição Y fora da janela
        if (positionY <= this.raio || positionY >= territorio.alturaJanela - (2 * this.raio)) {
            positionY = territorio.alturaJanela / 2;
        }

        this.y = positionY;
    }

    public Color getColor() {
        return this.cor;
    }
}