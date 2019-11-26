import formulario.Formulario;
import jogo.Dados;

import java.io.IOException;

public class Testes {
    private static Dados dados = new Dados("asdas", 123, 123, 123, 123, 123);

    public static void main(String[] args) {
        Formulario form = new Formulario("adas");
        try {
            dados.salvar("testes");
            Dados dados1 = Dados.abrir("testes.trt");
            System.out.println(dados1.getNome());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
