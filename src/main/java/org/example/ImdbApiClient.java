package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {

    private String linkApi;
    private static String apiKey;

    public ImdbApiClient() {
    }

    public ImdbApiClient(String apiKey) {
        this.apiKey = apiKey;
    }
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;

    }

    public String getLinkApi() {
        return linkApi;
    }

    public void setLinkApi(String linkApi) {
        this.linkApi = linkApi;
    }

    public static HttpRequest chamadaApi() {
        HttpRequest httpRequest = HttpRequest.
                newBuilder().
                uri(URI.create("https://api.themoviedb.org/3/trending/movie/day?language=pt-BR")).
                header("Authorization", "Bearer " + apiKey).// autorizacao para visualizacao da api
                        header("accept", "application/json").
                build();

        return httpRequest;
    }

    public  String getBody(){
        // cria uma instancia do http cliente
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(chamadaApi(), HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.getStackTrace();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        return response.body();
    }

}
