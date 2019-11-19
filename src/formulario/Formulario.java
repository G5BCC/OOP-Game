package formulario;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import exceptions.ExcecaoCamposNaoPreenchidos;

public class Formulario{
    protected JFrame frame;
    private JPanel painel;

    // Flags
    private boolean camposOK = false;
    public boolean validacao = false;

    // Parâmetros para execução do jogo
    private int janelaX = 0, janelaY = 0, pontuacaoMaxima = 0, ritmoJogo = 0, quantidadeObjetos = 0;
    private String nomeJogador = "";

    // Campos
    private JTextField textFieldQuantidadeObjetos, textFieldPontuacaoMaxima, textFieldRitmoJogo, textFieldTamanhoX,
                       textFieldTamanhoY, textFieldNomeJogador;

    private ArrayList<JTextField> listaCampos;

    public Formulario(String tituloFormulario) {
        frame = new JFrame(tituloFormulario);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        painel = new JPanel();
        frame.add(painel);
        inserir_componentes(painel);
        frame.setVisible(true);

        listaCampos = new ArrayList<>();
        listaCampos.add(textFieldTamanhoX);
        listaCampos.add(textFieldTamanhoY);
        listaCampos.add(textFieldPontuacaoMaxima);
        listaCampos.add(textFieldNomeJogador);
        listaCampos.add(textFieldQuantidadeObjetos);
        listaCampos.add(textFieldRitmoJogo);
    }

    private void inserir_componentes(JPanel panel) {
        panel.setLayout(null);

        // Tamanho do território (janela)
        JLabel labelTamanhoInicialTerritorio = new JLabel("Tamanho inicial do território");
        labelTamanhoInicialTerritorio.setBounds(10, 10, 200, 25);
        panel.add(labelTamanhoInicialTerritorio);

        JLabel labelTamanhoX = new JLabel("Largura:");
        JLabel labelTamanhoY = new JLabel("Altura:");

        labelTamanhoX.setBounds(30, 31, 50, 25);
        labelTamanhoY.setBounds(36, 58, 50, 25);

        panel.add(labelTamanhoX);
        panel.add(labelTamanhoY);

        textFieldTamanhoX = new JTextField(4);
        textFieldTamanhoY = new JTextField(4);

        textFieldTamanhoX.setBounds(82, 35, 40, 20);
        textFieldTamanhoY.setBounds(82, 60, 40, 20);

        panel.add(textFieldTamanhoX);
        panel.add(textFieldTamanhoY);

        // Ritmo do jogo
        JLabel labelRitmoJogo = new JLabel("Ritmo do jogo (milisegundos) ");
        labelRitmoJogo.setBounds(15, 110, 180, 20);
        panel.add(labelRitmoJogo);

        textFieldRitmoJogo = new JTextField(4);
        textFieldRitmoJogo.setBounds(70, 135, 45, 20);
        panel.add(textFieldRitmoJogo);

        // Pontuação máxima permitida
        JLabel labelPontuacaoMaxima = new JLabel("Pontuação máxima permitida ");
        labelPontuacaoMaxima.setBounds(250, 10, 230, 20);
        panel.add(labelPontuacaoMaxima);

        textFieldPontuacaoMaxima = new JTextField(4);
        textFieldPontuacaoMaxima.setBounds(305, 35, 60, 20);
        panel.add(textFieldPontuacaoMaxima);

        // Quantidade de objetos da classe A criados durante o jogo
        JLabel labelQuantidadeObjetos = new JLabel("Quantidade inicial de inimigos ");
        labelQuantidadeObjetos.setBounds(250, 110, 300, 20);
        panel.add(labelQuantidadeObjetos);

        textFieldQuantidadeObjetos = new JTextField(4);
        textFieldQuantidadeObjetos.setBounds(320, 135, 30, 20);
        panel.add(textFieldQuantidadeObjetos);

        // Jogador
        JLabel labelNomeJogador = new JLabel("Nome ");
        labelNomeJogador.setBounds(220, 170, 100, 20);
        panel.add(labelNomeJogador);

        textFieldNomeJogador = new JTextField(20);
        textFieldNomeJogador.setBounds(190, 190, 100, 20);
        panel.add(textFieldNomeJogador);

        // Botões
        JButton botaoOK = new JButton("Começar");
        JButton botaoSair = new JButton("Sair");

        botaoOK.setBounds(120, 220, 100, 30);
        botaoSair.setBounds(260, 220, 100, 30);

        panel.add(botaoOK);
        panel.add(botaoSair);

        ActionListener leitorBotoes = new LeitorBotoes(this);
        botaoOK.addActionListener(leitorBotoes);
        botaoSair.addActionListener(leitorBotoes);
    }

    public void validarCampos() throws ExcecaoCamposNaoPreenchidos {
        for(JTextField campo : listaCampos){
            if(campo.getText().length() > 0){
                camposOK = true;
            } else {
                camposOK = false;
            }
        }

        if(camposOK){
            // Pegar valores dos campos de texto
            this.janelaX = new Integer(textFieldTamanhoX.getText());
            this.janelaY = new Integer(textFieldTamanhoY.getText());
            this.quantidadeObjetos = new Integer(textFieldQuantidadeObjetos.getText());
            this.pontuacaoMaxima = new Integer(textFieldPontuacaoMaxima.getText());
            this.ritmoJogo = new Integer(textFieldRitmoJogo.getText());
            this.nomeJogador = textFieldNomeJogador.getText();
            this.frame.setFocusable(false);
            this.frame.setVisible(false);
            this.validacao = true;

            JOptionPane.showMessageDialog(this.frame, "OK, " + nomeJogador +"! Vamos jogar!");

        } else {
            throw new ExcecaoCamposNaoPreenchidos("Faltou preencher um dos campos!");
        }

    }

    public int getX(){
        return janelaX;
    }

    public int getY(){
        return janelaY;
    }

    public int getQuantidadeObjetos(){
        return quantidadeObjetos;
    }

    public int getRitmoJogo(){
        return ritmoJogo;
    }

    public int getPontuacaoMaxima(){
        return pontuacaoMaxima;
    }

    public String getNomeJogador(){
        return nomeJogador;
    }
}