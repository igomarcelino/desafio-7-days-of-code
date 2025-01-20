package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args)  {

        // cria uma requisicao do tipo GET
        HttpRequest httpRequest = HttpRequest.
                newBuilder().
                uri(URI.create("https://api.themoviedb.org/3/trending/movie/day?language=pt-BR")).
                header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMzBlOTY4YjJkYTg1YzhlZGNiNjI2YTM1ZmJjZTkzZiIsIm5iZiI6MTczNzM4MTE4Mi4zNzY5OTk5LCJzdWIiOiI2NzhlNTUzZWRiY2ZmMzNhOWM2NTU3YTYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0._jMtPU8KDGEj8gj-ytwUBJlYuA2K2TGKVq5lPqYiDzk").// autorizacao para visualizacao da api
                header("accept", "application/json").
                build();
        // cria uma instancia do http cliente
        HttpClient httpClient = HttpClient.newHttpClient();
        // enviando a requisicao de forma assincrona e esperando a resposta
        String body = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).
                thenApply(HttpResponse::body).join();
        // imprime no console a resposta obtida
        System.out.println(body);
    }
}