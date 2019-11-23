package formulario.botoes;

import formulario.Formulario;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LeitorBotoesComecar implements ActionListener {
    private Formulario formulario;
    private String caminho;

    public LeitorBotoesComecar(Formulario form){
        this.formulario = form;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        formulario.comecarJogo();
    }
}