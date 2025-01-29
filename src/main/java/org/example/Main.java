package org.example;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // cria uma requisicao do tipo GET
        String json = new ImdbApiClient("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMzBlOTY4YjJkYTg1YzhlZGNiNjI2YTM1ZmJjZTkzZiIsIm5iZiI6MTczNzM4MTE4Mi4zNzY5OTk5LCJzdWIiOiI2NzhlNTUzZWRiY2ZmMzNhOWM2NTU3YTYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0._jMtPU8KDGEj8gj-ytwUBJlYuA2K2TGKVq5lPqYiDzk").getBody();

        /**
         * Extraindo a lista de filmes de dentro da pagina e adicionando a uma lista de filmes
         * */

        List<Movie> movies = new JsonParse(json).parseJson();
        HTMLGenerator htmlGenerator;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/org/example/index.html"))){
            htmlGenerator = new HTMLGenerator(bufferedWriter);
            htmlGenerator.generate(movies);
        }

    }
}