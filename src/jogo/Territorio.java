package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Territorio extends JPanel {
    private ArrayList<Inimigo> listaInimigos;
    private JFrame janela;
    private Jogador jogador;

    protected static int titulo = 20;
    protected int pontos = 0;
    protected int pontosMaximos;
    protected int ritmo;
    protected int quantidadeInimigos;
    protected String nome;
    private boolean tipoFim;

    protected int larguraJanela, alturaJanela;

    // Método construtor
    public Territorio(String nome, int larguraJanela, int alturaJanela, int quantidadeInimigos, int pontosMaximos, int ritmo) {
        System.out.println("Criando " + getClass().getSimpleName() + " " + nome + " no construtor Territorio");

        this.nome = nome;
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
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação do jogador principal
        jogador = new Jogador(Color.BLUE, this);

        // Criação dos inimigos
        listaInimigos = new ArrayList<>();
        for (int i = 0; i < this.quantidadeInimigos; i++) {
            listaInimigos.add(new Inimigo(Color.RED, this));
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

        // Desenho da pontuação atual
        desenho.setColor(Color.GRAY);
        desenho.setFont(new Font("cursive", Font.BOLD, 16));
        desenho.drawString("Pontos: " + pontos, 10, 30);

        // Desenho da pontuação máxima
        desenho.setColor(Color.GRAY);
        desenho.setFont(new Font("cursive", Font.BOLD, 16));
        desenho.drawString("Pontuação máxima: " + pontosMaximos, larguraJanela - 250, 30);

        if (jogador != null) {
            jogador.paint(g);

            // Desenha os inimigos que estão dentro do ArrayList
            for (Inimigo inimigo: listaInimigos) {
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
        janela.setVisible(true);

        while (true) {
            // Captura das dimensões da janela
            larguraJanela = getWidth();
            alturaJanela = getHeight();

            pontos++;

            // Muda a posição dos inimigos no eixo X
            for (Inimigo listaInimigo : listaInimigos) {
                listaInimigo.setX(5);
            }

            // Criação de mais inimigos a cada 150 pontos
            if (pontos % 150 == 0) {
                listaInimigos.add(new Inimigo(Color.RED, this));
            }

            // Mudar a condição para colisão do jogador principal com os inimigos
            if (pontos >= pontosMaximos) {
                tipoFim = true;
                break;
            }

            if (colisao()) {
                tipoFim = false;
                break;
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

    private boolean colisao() {
        int xA = jogador.getX();
        int yA = jogador.getY();

        for (Inimigo inimigo: listaInimigos) {
            int xB = inimigo.getX();
            int yB = inimigo.getY();

            // Comparação da distância entre o centro do jogador e do inimigo
            if ((Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2)) <= (2 * jogador.raio) - 1)) {
                return true;
            }
        }

        return false;
    }

    private void game_over() {
        String mensagem;

        if (tipoFim) {
            mensagem = "Parabéns! Você alcançou os " + pontos + " pontos!";
        }
        else {
            mensagem = "Que pena! Você perdeu... Pelo menos conseguiu " + pontos + " pontos!";
        }

        JOptionPane.showMessageDialog(this, mensagem, "Game Over", JOptionPane.ERROR_MESSAGE);
    }
}