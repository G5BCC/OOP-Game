package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Territorio extends JPanel {
    // Atributos
    ArrayList<Jogador> inimigos = new ArrayList();

    private JFrame janela;
    private Jogador jogador;
    private Jogador inimigo;

    private static int titulo = 20;
    private int pontos = 0;
    private int pontosMaximos = 0;
    private int ritmo = 50; // deve estar em milissegundos


    public int larguraJanela;
    public int alturaJanela;

    // Método construtor
    public Territorio(String nome, int largura, int altura, int pontosMaximos, int ritmo, int quantidadeInimigos) {

        this.pontosMaximos = pontosMaximos;
        this.larguraJanela = largura;
        this.alturaJanela = altura;
        this.ritmo = ritmo;

        // Criação da janela
        janela = new JFrame(nome);
        janela.add(this);
        janela.setSize(largura, altura + titulo);
        janela.setResizable(false);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        larguraJanela = getWidth();
        alturaJanela = getHeight();

        // Criação do jogador principal
        jogador = new Jogador(Color.BLUE, this);
        jogador.posicaoInicial(30, alturaJanela / 2);

        // Criação dos inimigos
        for (int i = 0; i < quantidadeInimigos; i++) {
            inimigos.add(new Jogador(Color.RED, this));
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
            for (int i = 0; i < inimigos.size(); i++) {
                inimigos.get(i).paint(g);

                // Muda a posição no eixo X e Y dos inimigos após chegarem ao final da janela
                if (inimigos.get(i).posicaoX() <= -inimigos.get(i).diametro) {
                    inimigos.get(i).moverX(-larguraJanela);
                    inimigos.get(i).novaPosicaoY();
                }
            }
        }
    }

    // Método para iniciar o jogo
    public void jogar() {
        boolean jogando = true;

        while (jogando) {
            // Captura das dimensões da janela
            larguraJanela = getWidth();
            alturaJanela = getHeight();

            pontos++;

            // Muda a posição dos inimigos no eixo X
            for (int i = 0; i < inimigos.size(); i++) {
                inimigos.get(i).moverX(5);
            }

            // Criação de mais inimigos a cada 100 pontos
            if (pontos % 100 == 0) {
                inimigos.add(new Jogador(Color.RED, this));
            }

            // Mudar a condição para colisão do jogador principal com os inimigos
            if (pontos >= pontosMaximos) {
                jogando = false;
            }

            repaint();    // Atualização da janela

            try {
                Thread.sleep(ritmo);    // Espera em milisegundos
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        game_over();    // Fim do jogo após acontecer a condição
    }

    // Método para mostar uma mensagem ao final do jogo
    public void game_over() {
        String mensagem = "Que pena! Você perdeu... Pelo menos acumulou " + pontos + " pontos!";
        JOptionPane.showMessageDialog(this, mensagem, "Game Over", JOptionPane.YES_NO_OPTION);
    }
}