package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Territorio extends JPanel {
    private ArrayList<Inimigo> inimigos;
    private JFrame janela;
    private Jogador jogador;

    private static int titulo = 20;
    private int pontos = 0;
    private int pontosMaximos;
    private int ritmo; // deve estar em milissegundos
    private int quantidadeInimigos;

    public int larguraJanela;
    public int alturaJanela;

    // Método construtor
    public Territorio(String nome, int larguraJanela, int alturaJanela, int quantidadeInimigos, int pontosMaximos, int ritmo) {
        inimigos = new ArrayList<>();

        this.larguraJanela = larguraJanela;
        this.alturaJanela = alturaJanela;
        this.quantidadeInimigos = quantidadeInimigos;
        this.pontosMaximos = pontosMaximos;
        this.ritmo = ritmo;

        // Criação da janela
        janela = new JFrame(nome);
        janela.add(this);
        janela.setSize(larguraJanela, alturaJanela + titulo);
        janela.setResizable(true);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação do jogador principal
        jogador = new Jogador(Color.BLUE, this);

        // Criação dos inimigos
        for (int i = 0; i < this.quantidadeInimigos; i++) {
            inimigos.add(new Inimigo(Color.RED, this));
        }

        // Criação do teclado para o jogador principal
        KeyListener teclado = new Teclado(jogador);
        addKeyListener(teclado);
        setFocusable(true);
    }

    // Método para escrever e desenhar objetos na janela
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D desenho = (Graphics2D) g;
        desenho.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenho da pontuação
        desenho.setColor(Color.GRAY);
        desenho.setFont(new Font("Verdana", Font.BOLD, 16));
        desenho.drawString("Pontos: " + pontos, 10, 30);

        if (jogador != null) {
            jogador.paint(g);

            // Desenha os inimigos que estão dentro do ArrayList
            for (Inimigo inimigo: inimigos) {
                inimigo.paint(g);

                // Ao chegar ao fnal da janela no eixo X (0 - diametro do inimigo)
                if (inimigo.getX() <= -inimigo.raio) {
                    inimigo.setX(- larguraJanela - inimigo.raio);

                    // Checar se o inimigo está fora da janela
                    if (inimigo.getY() >= 0 && inimigo.getY() <= alturaJanela) {
                        inimigo.setY();
                    }
                }
            }
        }
    }

    // Método para iniciar o jogo
    public void jogar() {
        boolean play = true;

        while (play) {
            // Captura das dimensões da janela
            larguraJanela = getWidth();
            alturaJanela = getHeight();

            pontos++;

            // Muda a posição dos inimigos no eixo X
            for (int i = 0; i < inimigos.size(); i++) {
                inimigos.get(i).setX(5);
            }

            // Criação de mais inimigos a cada 100 pontos
            if (pontos % 100 == 0) {
                inimigos.add(new Inimigo(Color.RED, this));
            }

            // Mudar a condição para colisão do jogador principal com os inimigos
            if (pontos >= pontosMaximos) {
                play = false;
            }

            repaint();    // Atualização da janela

            try {
                Thread.sleep(ritmo);    // Espera em milisegundos
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        game_over();
    }

    private void game_over() {
        String mensagem = "Que pena! Você perdeu... Pelo menos acumulou " + pontos + " pontos!";
        JOptionPane.showMessageDialog(this, mensagem, "Game Over", JOptionPane.ERROR_MESSAGE);
    }
}