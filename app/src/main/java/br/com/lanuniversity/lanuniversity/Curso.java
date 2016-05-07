package br.com.lanuniversity.lanuniversity;

/**
 * Created by haraldo on 30/04/16.
 */
public class Curso {
    private String nomeDoCurso;
    private String conteudoDoCurso;

    public Curso() {
    }

    public Curso(String nomeDoCurso, String conteudoDoCurso) {

        this.nomeDoCurso = nomeDoCurso;
        this.conteudoDoCurso = conteudoDoCurso;
    }

    public String getNomeDoCurso() {

        return nomeDoCurso;
    }

    public void setNomeDoCurso(String nomeDoCurso) {

        this.nomeDoCurso = nomeDoCurso;
    }

    public String getConteudoDoCurso() {

        return conteudoDoCurso;
    }

    public void setConteudoDoCurso(String conteudoDoCurso) {

        this.conteudoDoCurso = conteudoDoCurso;
    }
}
