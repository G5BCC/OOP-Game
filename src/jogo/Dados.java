package jogo;

import java.io.*;

public class Dados extends Territorio implements Serializable{
    public Dados(String nome, int larguraJanela, int alturaJanela, int quantidadeInimigos, int pontosMaximos, int ritmo)
    {
        super(nome, larguraJanela, alturaJanela, quantidadeInimigos, pontosMaximos, ritmo);
    }

    public void salvar(String nomeArquivo) throws IOException {
        String caminho = new File(".").getCanonicalPath() + "/saves/";
        FileOutputStream arquivo = new FileOutputStream(caminho + nomeArquivo + ".trt");
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
        System.out.println("Salvando arquivo " + nomeArquivo + ".trt");
    }

    public static Dados abrir(String nomeArquivo) throws IOException, ClassNotFoundException{
        Dados dados = null;

        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        dados = (Dados) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return dados;
    }

    public String getNome(){
        return nome;
    }

    public int getX(){
        return larguraJanela;
    }

    public int getY(){
        return alturaJanela;
    }

    public int quantInimigos(){
        return quantidadeInimigos;
    }

    public int pontosMaximos(){
        return pontosMaximos;
    }

    public int ritmoJogo(){
        return ritmo;
    }
}