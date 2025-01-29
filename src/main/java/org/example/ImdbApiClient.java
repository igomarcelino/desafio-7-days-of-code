package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {

    private String linkApi;

    public ImdbApiClient() {
    }

    public ImdbApiClient(String linkApi) {
        this.linkApi = linkApi;
    }

    public String getLinkApi() {
        return linkApi;
    }

    public void setLinkApi(String linkApi) {
        this.linkApi = linkApi;
    }

    public static HttpResponse<String> chamadaApi(String uriAPI) {
        HttpRequest httpRequest = HttpRequest.
                newBuilder().
                uri(URI.create(uriAPI)).
                header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMzBlOTY4YjJkYTg1YzhlZGNiNjI2YTM1ZmJjZTkzZiIsIm5iZiI6MTczNzM4MTE4Mi4zNzY5OTk5LCJzdWIiOiI2NzhlNTUzZWRiY2ZmMzNhOWM2NTU3YTYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0._jMtPU8KDGEj8gj-ytwUBJlYuA2K2TGKVq5lPqYiDzk").// autorizacao para visualizacao da api
                        header("accept", "application/json").
                build();
        // cria uma instancia do http cliente
        HttpClient httpClient = HttpClient.newHttpClient();
        // enviando a requisicao de forma assincrona e esperando a resposta


        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.getStackTrace();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        return response;
    }

}
