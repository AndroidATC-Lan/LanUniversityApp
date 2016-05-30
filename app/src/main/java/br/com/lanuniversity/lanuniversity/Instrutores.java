/**
 * Created by Haraldo Filho<haraldo.filho@gmail.com> on 30/04/16.
 *
 * Classe responsável por fazer o parse do arquivo json em:
 * http://ragazzid.com.br/v1/site/instrutores
 *
 */

package br.com.lanuniversity.lanuniversity;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Instrutores {

    private List<Instrutor> instrutores;

    public Instrutores() {

        this.instrutores = null;
    }

    // Metodo que retorna a lista de objetos Instrutor
    public List<Instrutor> getInstrutores(String json) throws IOException {

        this.instrutores = parserJSON(json);
        Log.d("Conteudo Json","Instrutores: " + json);

        // Imprime log com o conteudo de cada objeto Instrutor
        Iterator<Instrutor> it= this.instrutores.iterator();
        while(it.hasNext()){
            Instrutor instrutor = it.next();
            Log.d("Objeto Instrutor","Nome: " + instrutor.getNome());
            Log.d("Objeto Instrutor","Historia: " + instrutor.getHistoriaDoInstrutor());
            Log.d("Objeto Instrutor","Foto: " + instrutor.getFotoDoInstrutor());
        }

        return this.instrutores;

    }

    // Metodo que faz o parse do aquivo json
    public List<Instrutor> parserJSON(String json) throws IOException {

        // cria uma lista de objetos Instrutor
        List<Instrutor> instrutores = new ArrayList<Instrutor>();
        try {
            JSONArray jsonInstrutores = new JSONArray(json);
            // adiciona cada objeto Instrutor na lista
            for (int i = 0; i < jsonInstrutores.length(); i++ ) {
                JSONObject jsonInstrutor = jsonInstrutores.getJSONObject(i);
                // cria um iterator para recuperar o valor de cada json key (nome do instrutor)
                Iterator<String> it = jsonInstrutor.keys();
                if(it.hasNext()) {
                    String key = it.next();
                    String value = jsonInstrutor.getString(key);
                    // cria um objeto do tipo Instrutor e insere valores
                    Instrutor instrutor = new Instrutor();
                    instrutor.setNome(key);
                    // valores de historia e foto estao em um json array
                    JSONArray instrutorArray = new JSONArray(value);
                    instrutor.setHistoriaDoInstrutor(instrutorArray.getString(0));
                    instrutor.setFotoDoInstrutor(instrutorArray.getString(1));
                    instrutores.add(instrutor);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return instrutores;

    }
}
