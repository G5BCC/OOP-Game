package formulario.botoes;

import formulario.Formulario;
import jogo.Dados;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeitorBotoesComecar implements ActionListener {
    private Formulario formulario;

    public LeitorBotoesComecar(Formulario form){
        this.formulario = form;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        formulario.comecarJogo();
    }
}