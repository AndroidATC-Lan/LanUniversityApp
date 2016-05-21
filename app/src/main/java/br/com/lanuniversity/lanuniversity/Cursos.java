/**
 * Created by Haraldo Filho<haraldo.filho@gmail.com> on 30/04/16.
 *
 * Classe responsável por fazer o parse do arquivo json em:
 * http://ragazzid.com.br/v1/site/cursos
 *
 */

package br.com.lanuniversity.lanuniversity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cursos {

    private List<Curso> cursos;

    public Cursos() {

        this.cursos = null;
    }

    // Metodo que retorna a lista de objetos Curso
    public List<Curso> getCursos(String json) throws IOException {

        this.cursos = parserJSON(json);
        Log.d("Conteudo Json","Cursos: " + json);

        // Imprime log com o conteudo de cada objeto Curso
        Iterator<Curso> it = this.cursos.iterator();
            while(it.hasNext()){
            Curso curso = it.next();
            Log.d("Objeto Curso","Nome: " + curso.getNomeDoCurso());
            Log.d("Objeto Curso","Conteudo: " + curso.getConteudoDoCurso());
        }

        return this.cursos;

    }

    // Metodo que faz o parse do aquivo json
    public List<Curso> parserJSON(String json) throws IOException {

        // cria uma lista de objetos Curso
        List<Curso> cursos = new ArrayList<Curso>();
        try {
            JSONArray jsonCursos = new JSONArray(json);
            // adiciona cada objeto Curso na lista
            for (int i = 0; i < jsonCursos.length(); i++ ) {
                JSONObject jsonCurso = jsonCursos.getJSONObject(i);
                // cria um iterator para recuperar o valor de cada json key (nome do curso)
                Iterator<String> it = jsonCurso.keys();
                while (it.hasNext()) {
                    String key = it.next();
                    // recupera o campo conteudo do curso com a key
                    String value = jsonCurso.getString(key);
                    // cria um objeto do tipo Curso e insere valores
                    Curso curso = new Curso();
                    curso.setNomeDoCurso(key);
                    curso.setConteudoDoCurso(value);
                    cursos.add(curso);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cursos;

    }

}
