package br.com.lanuniversity.lanuniversity;


import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by Matheus on 5/7/16.
 */
public class HttpJsonConnectionTest {

    @Test
    public void JsonGetTest(){
        HttpJsonConnection httpJsonConnection = new HttpJsonConnection();
        try {
            String jsonString = httpJsonConnection.execute("http://ragazzid.com.br/v1/").get();
            Assert.assertNotNull(jsonString);
            System.out.println(jsonString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}