package org.example.requestResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetExample {
  public static void main(String[] args)
  {
    try {
      String url = "https://jsonplaceholder.typicode.com/posts/4";
      URL obj = new URL(url); //Uniform Resource Loader , kaynak bulucu gibi
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // GET isteği ayarları
      con.setRequestMethod("GET");

      int responseCode = con.getResponseCode();
      System.out.println("GET Response Code :: " + responseCode); //TODO burası response için oluşan 200,400,401,404,500 kodlarını verir.

      if (responseCode == HttpURLConnection.HTTP_OK) //TODO HTTP_OK bir enum gibi tanımlanan bir final int değişkeni
      {
        // Başarılı ise
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
        {
          response.append(inputLine);
        }
        in.close();

        // Yanıtı yazdır
        System.out.println(response.toString());
      } else {
        System.out.println("GET request not worked");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
