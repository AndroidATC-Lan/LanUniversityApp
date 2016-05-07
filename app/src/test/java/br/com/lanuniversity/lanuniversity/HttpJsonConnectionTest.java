package br.com.lanuniversity.lanuniversity;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by Matheus on 5/7/16.
 */
public class HttpJsonConnectionTest  {
    final public String cHTTP_JSON_CONNECTION_TEST = "http://ragazzid.com.br/v1/";

    @Test
    public void JsonGetTest(){
        HttpJsonConnection httpJsonConnection = new HttpJsonConnection();
        try {
            String jsonString = httpJsonConnection.execute(cHTTP_JSON_CONNECTION_TEST).get();
            assertNotNull(jsonString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}