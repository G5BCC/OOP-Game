package jogo;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Jogador extends Personagem {
    private boolean left, right, up, down;

    public Jogador(Color cor, Territorio territorio) {
        super(cor, territorio);
        this.x = 30;
        this.y = territorio.alturaJanela / 2;
    }

    public void paint(Graphics g) {
        Graphics2D desenho = (Graphics2D) g;

        desenho.setColor(this.cor);
        desenho.fillOval(this.x, this.y, this.largura, this.altura);

        movement();
    }

    public void keyPressed(KeyEvent tecla) {
        switch (tecla.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                left = true;
                break;
            }
            case KeyEvent.VK_RIGHT: {
                right = true;
                break;
            }
            case KeyEvent.VK_UP: {
                up = true;
                break;
            }
            case KeyEvent.VK_DOWN: {
                down = true;
                break;
            }
        }
    }

    public void keyReleased(KeyEvent tecla) {
        switch (tecla.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                left = false;
                break;
            }
            case KeyEvent.VK_RIGHT: {
                right = false;
                break;
            }
            case KeyEvent.VK_UP: {
                up = false;
                break;
            }
            case KeyEvent.VK_DOWN: {
                down = false;
                break;
            }
        }
    }

    private void movement() {
        if (left && this.x >= 5) {
            this.x -= 5;
        }

        if (right && this.x <= territorio.larguraJanela - (2 * this.raio)) {
            this.x += 5;
        }

        if (up && this.y >= 5) {
            this.y -= 5;
        }

        if (down && this.y <= territorio.alturaJanela - (2 * this.raio) - 2) {
            this.y += 5;
        }
    }
}
