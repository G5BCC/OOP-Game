import exceptions.ExcecaoCamposNaoPreenchidos;
import formulario.Formulario;
import jogo.Territorio;

public class Main {
    public static void main(String[] args) {
        Formulario form = new Formulario();
        Territorio area;
        System.out.println("Validação");
        while (true) {
            if (form.validacao) {
                area = new Territorio(form.nomeJogador, form.janelaX, form.janelaY, form.quantidadeObjetos, form.pontuacaoMaxima, form.ritmoJogo);
                System.out.println("OK");
                break;
            }
            else {
                System.out.println("");
            }
        }
        area.jogar();
    }
}
