package src.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LeitorBotoes implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        JButton origem = (JButton) e.getSource();
        switch(origem.getText()){
            case "Sair":
                System.exit(0);
                break;
            case "Começar":
                JOptionPane.showMessageDialog(origem, "Começando jogo");
                break;
        }
    }
}