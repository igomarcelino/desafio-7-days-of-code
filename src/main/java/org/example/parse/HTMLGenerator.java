package org.example.parse;

import org.example.domain.Movie;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {


    private PrintWriter writer;

    public HTMLGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void generate(List<Movie> movies) throws IOException {

        String htmlDoc = """
                  <!DOCTYPE html>
                  <html> 
                    <head>
                        <meta charset="utf-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Desafio Alura 7 dias de código Java</title>
                        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
                    </head>
                    <body>
                  <h1> Lista de Filmes obtido pela API</h1>  
                  <div>
                    %s
                </div>
                </body>
                  </html>
                """;

        String divTemplate = """
                <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                    	<h4 class=\"card-header\">%s</h4>
                    	<div class=\"card-body\">
                    		<img class=\"card-img\" src=\"%s\" alt=\"%s\">
                    		<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                    	</div>
                    </div>
                """;
        StringBuilder stringDiv = new StringBuilder();

        for (Movie m : movies){
            stringDiv.append(String.format(divTemplate,m.getTitle(),m.getUrlImage(),m.getTitle(),m.getRating(),m.getYear()));
        }
        writer.write(String.format(htmlDoc,stringDiv));
    }
}
