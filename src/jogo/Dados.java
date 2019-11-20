package jogo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Dados extends Territorio {

    public Dados(String nome, int larguraJanela, int alturaJanela, int quantidadeInimigos, int pontosMaximos, int ritmo) {
        super(nome, larguraJanela, alturaJanela, quantidadeInimigos, pontosMaximos, ritmo);
    }

    public void salvar(String nomeArquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }
}
