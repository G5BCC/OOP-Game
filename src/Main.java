package src;

import src.jogo.Territorio;
import src.formulario.Formulario;

public class Main {

    public static void main(String[] args) {
        Formulario form = new Formulario();

        if(form.comecarJogo()){
            Territorio area = new Territorio("Jogo", form.getJanelaX(), form.getJanelaY(), form.getPontuacaoMaxima(), 
            form.getRitmoJogo(), form.getQuantidadeObjetos());
            area.jogar();
        }
        
    }
}
