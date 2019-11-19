package formulario;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import exceptions.ExcecaoCamposNaoPreenchidos;
import jogo.Territorio;

public class Formulario{
    protected JFrame frame;
    private JPanel painel;

    public Territorio territorio;

    // Flags
    private boolean camposOK = false;
    public boolean validacao = false;

    // Parâmetros para execução do jogo
    private int janelaX = 0, janelaY = 0, pontuacaoMaxima = 0, ritmoJogo = 0, quantidadeObjetos = 0;
    private String nomeJogador = "";

    // Campos
    private JTextField textFieldQuantidadeObjetos, textFieldPontuacaoMaxima, textFieldRitmoJogo, textFieldTamanhoX,
            textFieldTamanhoY, textFieldNomeJogador;

    ArrayList<JTextField> campos = new ArrayList<>();

    public Formulario(String tituloFormulario) {
        frame = new JFrame(tituloFormulario);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        painel = new JPanel();
        frame.add(painel);
        inserir_componentes(painel);

        frame.setVisible(true);

        campos.add(textFieldTamanhoX);
        campos.add(textFieldTamanhoY);
        campos.add(textFieldPontuacaoMaxima);
        campos.add(textFieldNomeJogador);
        campos.add(textFieldQuantidadeObjetos);
        campos.add(textFieldRitmoJogo);
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

    public void validarCampos() throws ExcecaoCamposNaoPreenchidos {
        for(JTextField tf : campos){
            if(!(tf.getText().length() <= 0)){
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
            this.frame.setVisible(false);

            JOptionPane.showMessageDialog(this.frame, "OK, " + nomeJogador +"! Vamos jogar!");

            validacao = true;
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

    public boolean getFlagCamposOK(){
        return this.camposOK;
    }
}