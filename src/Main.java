import jogo.Territorio;
import formulario.Formulario;

public class Main {

    public static void main(String[] args) {

        Territorio area;
        Formulario form = new Formulario();

        if(form.getEstadoJogo()){
            area = new Territorio("Jogo", form.getJanelaX(), form.getJanelaY(), form.getPontuacaoMaxima(),
                    form.getRitmoJogo(), form.getQuantidadeObjetos());
            area.jogar();
        }
    }
}
