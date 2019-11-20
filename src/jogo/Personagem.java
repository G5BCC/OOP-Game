package jogo;

import javax.swing.*;
import java.awt.*;
import java.io.*;

abstract public class Personagem extends JComponent {

    protected Territorio territorio;
    protected Color cor;

    protected int x, y;
    protected int altura = 30, largura = 30;
    protected int raio = largura / 2;

    abstract public void salvar(String nomeArquivo) throws IOException;
    abstract public Personagem abrir(String nomeArquivo) throws  IOException, ClassNotFoundException;

    abstract public void paint(Graphics g);

    public Personagem(Color cor, Territorio territorio) {
        this.cor = cor;
        this.territorio = territorio;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}