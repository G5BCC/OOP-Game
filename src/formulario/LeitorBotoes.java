package formulario;

import exceptions.ExcecaoCamposNaoPreenchidos;
import jogo.Territorio;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LeitorBotoes implements ActionListener {
    private Formulario formulario;

    public LeitorBotoes(Formulario form){
        this.formulario = form;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton origem = (JButton) e.getSource();
        final JFileChooser fileChooser;

        switch(origem.getText()){
            case "Sair":
                JOptionPane.showMessageDialog(origem, "Saindo do jogo");
                System.exit(0);
                break;
            case "Começar":
                try {
                    formulario.validarCampos();
                    formulario.salvar(formulario.getNomeJogador() + ".trt");
                } catch (ExcecaoCamposNaoPreenchidos ex){
                    JOptionPane.showMessageDialog(origem, ex.getMessage());
                } catch (IOException ignored){

                }
                break;
            case "Carregar":
                Territorio territorioSalvo;
                fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(origem);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        JOptionPane.showMessageDialog(origem, "Carregando território...");
                        formulario.sairFormulario();
                        territorioSalvo = formulario.abrir(selectedFile.getName());
                        territorioSalvo.jogar();
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(origem, ex.getMessage());
                    }
                }
                break;
        }
    }
}