package formulario.botoes;

import formulario.Formulario;
import jogo.Dados;
import jogo.Territorio;

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
                String caminho = jfc.getSelectedFile().getParent();
                String nomeArquivo = jfc.getSelectedFile().getName();
                String caminhoArquivo = caminho + "/" + nomeArquivo;

                System.out.println("    Objeto selecionado: " + nomeArquivo);
                System.out.println("    Caminho do objeto: " + caminho);

                Dados dados = Dados.abrir(caminhoArquivo);
                System.out.println("Carregando objeto persistente...");
                form.abrirJogo(dados);
            } catch (ClassNotFoundException | IOException | InterruptedException ex){
                JOptionPane.showMessageDialog(button, ex.getMessage());
            }
        }
    }
}