package org.example.requestResponse;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpPostExample {
  public static void main(String[] args)
  {
    try {
      String url = "https://httpbin.org/post"; //TODO fakeApi kullandım maksat response versin
      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      con.setRequestMethod("POST");
      con.setRequestProperty("Content-Type", "application/json; utf-8");
      con.setRequestProperty("Accept", "application/json");

      String jsonInputString = "{"
          + "\"userId\": 1,"
          + "\"id\": 10,"
          + "\"title\": \"post request\","
          + "\"body\": \"selamlar\""
          + "}";

      con.setDoOutput(true);
      try (OutputStream os = con.getOutputStream())
      {
        byte[] input = jsonInputString.getBytes("utf-8");//String Json verisini byte array yapıyor ,output'a yazıyor
        os.write(input, 0, input.length);
      }

      int responseCode = con.getResponseCode();
      System.out.println("POST Response Code :: " + responseCode);

      BufferedReader in;
      if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED)
      {
        in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
      }
      else
      {
        in = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
      }
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null)
      {
        response.append(inputLine); //StringBuilder yapısına responsu satır satır okuyor ve ekliyor
      }
      in.close(); //oluşturulan BufferedReaderi kapatıyor okuma bittiği için

      System.out.println(response.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
