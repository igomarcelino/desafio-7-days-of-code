package org.example;

import com.google.gson.Gson;

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
        HttpRequest httpRequest = HttpRequest.
                newBuilder().
                uri(URI.create("https://api.themoviedb.org/3/trending/movie/day?language=pt-BR")).
                header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMzBlOTY4YjJkYTg1YzhlZGNiNjI2YTM1ZmJjZTkzZiIsIm5iZiI6MTczNzM4MTE4Mi4zNzY5OTk5LCJzdWIiOiI2NzhlNTUzZWRiY2ZmMzNhOWM2NTU3YTYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0._jMtPU8KDGEj8gj-ytwUBJlYuA2K2TGKVq5lPqYiDzk").// autorizacao para visualizacao da api
                        header("accept", "application/json").
                build();
        // cria uma instancia do http cliente
        HttpClient httpClient = HttpClient.newHttpClient();
        // enviando a requisicao de forma assincrona e esperando a resposta
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        /**
         * Extraindo a lista de filmes de dentro da pagina e adicionando a uma lista de filmes
         * */
        List<MoviesFromAPI> moviesFromAPIList = new ArrayList<>();
        Gson gson = new Gson();
        Page page = gson.fromJson(response.body(), Page.class);
        moviesFromAPIList = page.getResults();

        /*List<String> titulos = moviesList.stream().map(Movies::getTitle).toList();
        List<String> urlImgs = moviesList.stream().map(Movies::getBackdropPath).toList();
        List<String> anoLancamento = moviesList.stream().map(Movies::getReleaseDate).toList();
        List<Double> notas = moviesList.stream().map(Movies::getVoteAverage).toList();*/

        List<Movie> movies = new ArrayList<>();
        movies = moviesFromAPIList.stream().map(Movie::new).toList();
        for (Movie movie : movies){
            System.out.println(movie);
        }
    }
}