package jogo;

import java.awt.*;
import java.io.*;
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

    public void salvar(String nomeArquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    public Inimigo abrir(String nomeArquivo) throws IOException, ClassNotFoundException{
        Inimigo inimigo = null;

        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        inimigo = (Inimigo) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return inimigo;
    }
}