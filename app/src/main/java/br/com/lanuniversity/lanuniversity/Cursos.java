package br.com.lanuniversity.lanuniversity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by haraldo on 30/04/16.
 */
public class Cursos {

    private List<Curso> cursos;

    public Cursos() {

        this.cursos = null;
    }

    public List<Curso> getCursos(String json) throws IOException {

        this.cursos = parserJSON(json);
        Log.d("Acesso", "Cursos json: " + json);

        Iterator<Curso> cursosIterator= this.cursos.iterator();
        while(cursosIterator.hasNext()){
            Curso curso = cursosIterator.next();
            Log.d("Objeto Curso","Nome: " + curso.getNomeDoCurso());
            Log.d("Objeto Curso","Conteudo: " + curso.getConteudoDoCurso());
        }

        return this.cursos;

    }

    public List<Curso> parserJSON(String json) throws IOException {

        List<Curso> cursos = new ArrayList<Curso>();
        try {

            JSONArray jsonCursos = new JSONArray(json);
            // insere cada curso na lista
            for (int i = 0; i < jsonCursos.length(); i++ ) {
                JSONObject jsonCurso = jsonCursos.getJSONObject(i);
                // Cria os objetos curso
                Iterator<String> cursosIterator = jsonCurso.keys();
                if(cursosIterator.hasNext()) {
                    Curso curso = new Curso();
                    String key = cursosIterator.next();
                    String value = jsonCurso.getString(key);
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
