import formulario.Formulario;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Formulario form = new Formulario("Formulário");

        while(!form.flagComecarJogo) {
            Thread.sleep(1000);    // Verificando o formulário a cada 1 segundo
        }

        System.out.println("Ok no Main");
        form.criarTerritorio();
    }
}
