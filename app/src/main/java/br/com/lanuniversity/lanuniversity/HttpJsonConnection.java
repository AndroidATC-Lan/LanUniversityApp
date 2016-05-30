package br.com.lanuniversity.lanuniversity;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Essa classe conecta a uma pagina http e retorna uma String contendo o JSON de qualquer URL ao
 * chamar o metodo execute() passando o endereco web como parametro e depois o metodo get()
 *
 * Criado por Matheus em 30/04/2016
 */

public class HttpJsonConnection extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        URL url;
        BufferedReader reader = null;

        //Inicializar conexao HTTP e ler dados
        try {
            //Converter String recebida para URL
            url = new URL(params[0]);
            //Request HTTP GET
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            //Receber InputStream do server
            InputStream stream = connection.getInputStream();

            //Ler stream
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line;
            //Converter linhas para texto
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            //Retornar ao onPostExecute
            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Fechar as conexoes
            if(connection != null) {
                connection.disconnect();
            }
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Retornar null se nao receber dados
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}