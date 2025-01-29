package org.example;

import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {

    private String jsonBody;

    public JsonParse(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    public List<Movie> parseJson(){
        List<MoviesFromAPI> moviesFromAPIList = new ArrayList<>();
        Gson gson = new Gson();
        Page page = gson.fromJson(jsonBody, Page.class);
        moviesFromAPIList = page.getResults();
        List<Movie> movies = new ArrayList<>();
        movies = moviesFromAPIList.stream().map(Movie::new).toList();
        return movies;
    }
}
