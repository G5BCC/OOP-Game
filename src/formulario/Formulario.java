package formulario;

import javax.swing.*;
import java.awt.event.ActionListener;
import exceptions.*;

public class Formulario{
    protected JFrame frame;
    private JPanel painel;

    // Flags
    private boolean camposOk = false;
    private boolean flagComecarJogo = false;

    // Parâmetros para execução do jogo
    private int janelaX = 0;
    private int janelaY = 0;
    private int pontuacaoMaxima = 0;
    private int ritmoJogo = 0;
    private int quantidadeObjetos = 0;
    private String nomeJogador = "";

    // Campos
    private JTextField textFieldQuantidadeObjetos;
    private JTextField textFieldPontuacaoMaxima;
    private JTextField textFieldRitmoJogo;
    private JTextField textFieldTamanhoX;
    private JTextField textFieldTamanhoY;
    private JTextField textFieldNomeJogador;

    public Formulario() {
        frame = new JFrame("teste");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        painel = new JPanel();
        frame.add(painel);
        inserir_componentes(painel);

        frame.setVisible(true);
    }

    private void inserir_componentes(JPanel panel) {
        panel.setLayout(null);

        // Tamanho do território (janela)
        JLabel labelTamanhoInicialTerritorio = new JLabel("Tamanho inicial do território");
        labelTamanhoInicialTerritorio.setBounds(10, 10, 200, 25);
        panel.add(labelTamanhoInicialTerritorio);

        JLabel labelTamanhoX = new JLabel("X:");
        JLabel labelTamanhoY = new JLabel("Y:");

        labelTamanhoX.setBounds(10, 50, 50, 25);
        labelTamanhoY.setBounds(10, 80, 50, 25);

        panel.add(labelTamanhoX);
        panel.add(labelTamanhoY);

        textFieldTamanhoX = new JTextField(4);
        textFieldTamanhoY = new JTextField(4);

        textFieldTamanhoX.setBounds(30, 50, 100, 25);
        textFieldTamanhoY.setBounds(30, 80, 100, 25);

        panel.add(textFieldTamanhoX);
        panel.add(textFieldTamanhoY);

        // Ritmo do jogo
        JLabel labelRitmoJogo = new JLabel("Ritmo do jogo: ");
        labelRitmoJogo.setBounds(180, 10, 100, 25);
        panel.add(labelRitmoJogo);

        textFieldRitmoJogo = new JTextField(4);
        textFieldRitmoJogo.setBounds(270, 10, 100, 25);
        panel.add(textFieldRitmoJogo);

        // Pontuação máxima permitida
        JLabel labelPontuacaoMaxima = new JLabel("Pontuação máxima permitida: ");
        labelPontuacaoMaxima.setBounds(180, 35, 230, 25);
        panel.add(labelPontuacaoMaxima);

        textFieldPontuacaoMaxima = new JTextField(4);
        textFieldPontuacaoMaxima.setBounds(360, 35, 100, 25);
        panel.add(textFieldPontuacaoMaxima);

        // Quantidade de objetos da classe A criados durante o jogo
        JLabel labelQuantidadeObjetos = new JLabel("Quantidade de objetos criados durante o jogo: ");
        labelQuantidadeObjetos.setBounds(180, 55, 300, 25);
        panel.add(labelQuantidadeObjetos);

        textFieldQuantidadeObjetos = new JTextField(4);
        textFieldQuantidadeObjetos.setBounds(180, 75, 100, 25);
        panel.add(textFieldQuantidadeObjetos);

        // Jogador
        JLabel labelNomeJogador = new JLabel("Nome: ");
        labelNomeJogador.setBounds(30, 160, 100, 25);
        panel.add(labelNomeJogador);

        textFieldNomeJogador = new JTextField(20);
        textFieldNomeJogador.setBounds(30, 180, 100, 25);
        panel.add(textFieldNomeJogador);

        // Botões
        JButton botaoOK = new JButton("Começar");
        JButton botaoSair = new JButton("Sair");

        botaoOK.setBounds(30, 200, 100, 30);
        botaoSair.setBounds(140, 200, 70, 30);

        panel.add(botaoOK);
        panel.add(botaoSair);

        ActionListener leitorBotoes = new LeitorBotoes(this);
        botaoOK.addActionListener(leitorBotoes);
        botaoSair.addActionListener(leitorBotoes);
    }

    protected void validarCampos() throws ExcecaoCamposNaoPreenchidos{
        if(textFieldPontuacaoMaxima.getText().length() <= 0
            || textFieldQuantidadeObjetos.getText().length() <= 0
            || textFieldRitmoJogo.getText().length() <= 0
            || textFieldTamanhoX.getText().length() <= 0
            || textFieldTamanhoY.getText().length() <= 0
            || textFieldNomeJogador.getText().length() <= 0){
            throw new ExcecaoCamposNaoPreenchidos("Faltou preencher um dos campos!");
        } else {
            this.janelaX = new Integer(textFieldTamanhoX.getText());
            this.janelaY = new Integer(textFieldTamanhoY.getText());
            this.quantidadeObjetos = new Integer(textFieldQuantidadeObjetos.getText());
            this.pontuacaoMaxima = new Integer(textFieldPontuacaoMaxima.getText());
            this.ritmoJogo = new Integer(textFieldRitmoJogo.getText());
            this.nomeJogador = textFieldNomeJogador.getText();
            JOptionPane.showMessageDialog(this.frame, "OK, " + nomeJogador +"! Vamos jogar!");
            sairFormulario();
        }
    }
    public int getJanelaX(){
        return this.janelaX;
    }

    public int getJanelaY(){
        return this.janelaY;
    }

    public int getPontuacaoMaxima(){
        return this.pontuacaoMaxima;
    }

    public int getRitmoJogo(){
        return this.ritmoJogo;
    }

    public int getQuantidadeObjetos(){
        return this.quantidadeObjetos;
    }

    public boolean getEstadoJogo(){
        return flagComecarJogo;
    }

    public void setEstadoJogo(boolean estado){
        flagComecarJogo = estado;
    }

    protected void sairFormulario(){
        this.frame.dispose();
    }
}