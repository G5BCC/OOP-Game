package jogo;

import java.io.*;

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
        System.out.println("Salvando arquivo " + nome + ".trt");
    }

    public Dados abrir(String nomeArquivo) throws IOException, ClassNotFoundException{
        Dados dados = null;

        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        dados = (Dados) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return dados;
    }

    public int getLargura(){
        return this.larguraJanela;
    }

    public int getAltura(){
        return this.alturaJanela;
    }

    public int getQuantInimigos(){
        return this.quantidadeInimigos;
    }

    public int getPontuacaoMax(){
        return this.pontosMaximos;
    }

    public int getRitmoJogo(){
        return this.ritmo;
    }

    public String getNome(){
        return this.nome;
    }
}
