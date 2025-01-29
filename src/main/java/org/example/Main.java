package org.example;

import org.example.Request.ImdbApiClient;
import org.example.domain.Movie;
import org.example.parse.HTMLGenerator;
import org.example.parse.JsonParse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String json = new ImdbApiClient("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMzBlOTY4YjJkYTg1YzhlZGNiNjI2YTM1ZmJjZTkzZiIsIm5iZiI6MTczNzM4MTE4Mi4zNzY5OTk5LCJzdWIiOiI2NzhlNTUzZWRiY2ZmMzNhOWM2NTU3YTYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0._jMtPU8KDGEj8gj-ytwUBJlYuA2K2TGKVq5lPqYiDzk").getBody();
        List<Movie> movies = new JsonParse(json).parseJson();
        PrintWriter writer = new PrintWriter("src/main/java/org/example/index.html");
        new HTMLGenerator(writer).generate(movies);
        writer.close();

    }
}