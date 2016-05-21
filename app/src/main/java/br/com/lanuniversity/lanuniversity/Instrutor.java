/**
 * Created by Haraldo Filho<haraldo.filho@gmail.com> on 30/04/16.
 *
 * Classe de objetos com as informacoes de um instrutor
 *
 */

package br.com.lanuniversity.lanuniversity;

public class Instrutor {

    private String nomeDoInstrutor;
    private String historiaDoInstrutor;
    private String fotoDoInstrutor;

    public Instrutor() {

    }

    public Instrutor(String nomeDoInstrutor, String historiaDoInstrutor, String fotoDoInstrutor) {
        this.nomeDoInstrutor = nomeDoInstrutor;
        this.historiaDoInstrutor = historiaDoInstrutor;
        this.fotoDoInstrutor = fotoDoInstrutor;
    }

    public String getNome() {

        return nomeDoInstrutor;
    }

    public void setNome(String nome) {

        this.nomeDoInstrutor = nome;
    }

    public String getHistoriaDoInstrutor() {

        return historiaDoInstrutor;
    }

    public void setHistoriaDoInstrutor(String historiaDoInstrutor) {

        this.historiaDoInstrutor = historiaDoInstrutor;
    }

    public String getFotoDoInstrutor() {

        return fotoDoInstrutor;
    }

    public void setFotoDoInstrutor(String fotoDoInstrutor) {

        this.fotoDoInstrutor = fotoDoInstrutor;
    }
}
