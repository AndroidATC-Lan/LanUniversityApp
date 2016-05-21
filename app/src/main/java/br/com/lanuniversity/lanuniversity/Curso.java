/**
 * Created by Haraldo Filho<haraldo.filho@gmail.com> on 30/04/16.
 *
 * Classe de objetos com as informacoes de um curso
 *
 */

package br.com.lanuniversity.lanuniversity;

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
