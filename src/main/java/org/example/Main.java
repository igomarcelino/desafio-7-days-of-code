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
                    uri(URI.create("")).
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