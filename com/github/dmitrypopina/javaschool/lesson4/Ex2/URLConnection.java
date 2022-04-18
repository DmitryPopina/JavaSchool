package com.github.dmitrypopina.javaschool.lesson4.Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class URLConnection {
    public static String getText(String url) throws Exception {
        URL website;
        try {
            website=new URL(url);
        }
        catch (MalformedURLException e)
        {
            return "Введен ошибочный URL сайта";
        }

        java.net.URLConnection connection = website.openConnection();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            return response.toString();
        }
        catch (UnknownHostException e) {
            return "Неизвестный хост, проверьте соединение";
        } catch (IOException e) {
            return "Неизвестная ошибка, проверьте соединение";
        }
    }
}
