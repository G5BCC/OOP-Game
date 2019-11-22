import formulario.Formulario;
import jogo.Dados;

public class Main {
    public static void main(String[] args) {
        Formulario form = new Formulario("Formulário");
        String caminho = "/home/pedrohorchulhack/Documents/Repositories/ProjetoPOO/saves/Pedasd.trt";

        try {
            Dados dados = form.abrir(caminho);
            System.out.println(dados.getLargura());
            System.out.println(dados.getAltura());
            System.out.println(dados.getNome());
            System.out.println(dados.getPontuacaoMax());
            System.out.println(dados.getQuantInimigos());
            System.out.println(dados.getRitmoJogo());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
