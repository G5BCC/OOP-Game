package formulario;

import exceptions.ExcecaoCamposNaoPreenchidos;

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
        switch(origem.getText()){
            case "Sair":
                JOptionPane.showMessageDialog(origem, "Saindo do jogo");
                System.exit(0);
                break;
            case "Começar":
                try{
                    formulario.validarCampos();
                } catch (ExcecaoCamposNaoPreenchidos ex){
                    JOptionPane.showMessageDialog(origem, ex.getMessage());
                }
                break;
        }
    }
}