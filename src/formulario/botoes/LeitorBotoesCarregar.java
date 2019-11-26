package formulario.botoes;

import formulario.Formulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LeitorBotoesCarregar implements ActionListener {
    private Formulario form;

    public LeitorBotoesCarregar(Formulario form){
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        JFileChooser jfc = new JFileChooser();
        int valor = jfc.showOpenDialog(button);
        jfc.setDialogTitle("Selecione um jogador para carregar: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if(valor == JFileChooser.APPROVE_OPTION){
            try{
                form.abrir(jfc.getSelectedFile().getName());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(button, ex.getStackTrace());
            }

        }

    }
}