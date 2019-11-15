import jogo.Territorio;
import formulario.Formulario;

public class Main {

    public static void main(String[] args) {
        //Formulario form = new Formulario();

        //if(form.comecarJogo()){
            Territorio area = new Territorio("Jogo", 800, 600, 1000000,
            50, 5);
            area.jogar();
        //}
        
    }
}
