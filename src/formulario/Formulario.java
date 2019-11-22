package formulario;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import exceptions.ExcecaoCamposNaoPreenchidos;
import formulario.botoes.*;
import jogo.Dados;
import jogo.Territorio;

public class Formulario{
    private JFrame frame;
    private JPanel painel;

    //Flags
    private boolean flagComecarJogo = false;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JButton botaoOK;
        JButton botaoSair;
        JButton botaoCarregar;

        botaoOK = new JButton("Começar");
        botaoSair = new JButton("Sair");
        botaoCarregar = new JButton("Carregar");

        botaoOK.setBounds(120, 220, 100, 30);
        botaoSair.setBounds(260, 220, 100, 30);
        botaoCarregar.setBounds(360, 220, 100, 30);

        panel.add(botaoOK);
        panel.add(botaoSair);
        panel.add(botaoCarregar);

        ActionListener leitorOK = new LeitorBotoesComecar(this);
        ActionListener leitorSair = new LeitorBotoesSair(this);
        ActionListener leitorCarregar = new LeitorBotoesCarregar(this);

        botaoOK.addActionListener(leitorOK);
        botaoSair.addActionListener(leitorSair);
        botaoCarregar.addActionListener(leitorCarregar);

    }

    private void validarCampos() throws ExcecaoCamposNaoPreenchidos {
        boolean camposOK = false;
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
            flagComecarJogo = true;
        } else {
            flagComecarJogo = false;
            throw new ExcecaoCamposNaoPreenchidos("Faltou preencher um dos campos!");
        }
    }

    public void salvar(String nomeArquivo) throws IOException{
        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        Territorio test;
        test = new Dados("Jogo de " + nomeJogador, janelaX, janelaY, quantidadeObjetos, pontuacaoMaxima, ritmoJogo);
        test.salvar(nomeArquivo);
    }

    public Dados abrir(String nomeArquivo) throws IOException, ClassNotFoundException{
        Dados territorio = null;

        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        territorio = (Dados) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return territorio;
    }

    public void comecarJogo(){
        if(flagComecarJogo){
            this.frame.setVisible(false);
            new Territorio(nomeJogador, janelaX, janelaY, quantidadeObjetos, pontuacaoMaxima, ritmoJogo);
        } else {
            try {
                validarCampos();
            } catch (ExcecaoCamposNaoPreenchidos e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }
    }

    public void sairFormulario(){
        switch (JOptionPane.showConfirmDialog(frame, "Deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION)){
            case 0:
                System.exit(1);
                break;
            default:
                break;
        }
    }

    public String getNomeJogador(){
        return nomeJogador;
    }
}