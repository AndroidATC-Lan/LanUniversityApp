/**
 * Created by Haraldo Filho<haraldo.filho@gmail.com> on 30/04/16.
 *
 * Classe responsável por fazer o parse do arquivo json em:
 * http://ragazzid.com.br/v1/site/sobre
 *
 */

package br.com.lanuniversity.lanuniversity;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class Sobre {

    private String sobre;

    public Sobre() {

        this.sobre = null;
    }

    // Metodo que retorna o texto extraido do arquivo json
    public String getSobre(String json) throws IOException {

        this.sobre = parserJSON(json);
        Log.d("Conteudo Json", "Sobre: " + json);
        Log.d("Objeto Sobre", sobre);

        return sobre;

    }

    // Metodo que faz o parse do aquivo json
    public String parserJSON(String json) throws IOException {

        String sobre = null;

        try {
            JSONObject sobreObj = new JSONObject(json);
            // recupera conteudo usando a key "texto"
            sobre = sobreObj.getString("texto");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sobre;

    }


}
