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
        HttpResponse<String> response = ImdbApiClient.chamadaApi("https://api.themoviedb.org/3/trending/movie/day?language=pt-BR");

        /**
         * Extraindo a lista de filmes de dentro da pagina e adicionando a uma lista de filmes
         * */
        List<MoviesFromAPI> moviesFromAPIList = new ArrayList<>();
        Gson gson = new Gson();
        Page page = gson.fromJson(response.body(), Page.class);
        moviesFromAPIList = page.getResults();



        List<Movie> movies = new ArrayList<>();
        movies = moviesFromAPIList.stream().map(Movie::new).toList();
        for (Movie movie : movies){
            System.out.println(movie);
        }
        HTMLGenerator htmlGenerator;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/org/example/index.html"))){
            htmlGenerator = new HTMLGenerator(bufferedWriter);
            htmlGenerator.generate(movies);
        }

    }
}