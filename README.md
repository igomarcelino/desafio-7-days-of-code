
---

<div align="left">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="40%" align="left" style="margin-right: 15px"/>
    <div style="display: inline-block;">
        <h2 style="display: inline-block; vertical-align: middle; margin-top: 0;">DESAFIO-7-DAYS-OF-CODE</h2>
        <p>
	<em><code>❯Igo- Marcelino</code></em>
</p>
        <p>
	<img src="https://img.shields.io/github/last-commit/igomarcelino/desafio-7-days-of-code?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/igomarcelino/desafio-7-days-of-code?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/igomarcelino/desafio-7-days-of-code?style=default&color=0080ff" alt="repo-language-count">
</p>
        <p><!-- default option, no dependency badges. -->
</p>
        <p>
	<!-- default option, no dependency badges. -->
</p>
    </div>
</div>
<br clear="left"/>

## 🔗 Índice

- [📍 Visão Geral](#-visao-geral)
- [👾 Funcionalidades](#-funcionalidades)
- [📁 Estrutura do Projeto](#-estrutura-do-projeto)
  - [📂 Índice do Projeto](#-indice-do-projeto)
- [🚀 Primeiros Passos](#-primeiros-passos)
  - [☑️ Pré-requisitos](#-pre-requisitos)
  - [⚙️ Instalação](#-instalacao)
  - [🤖 Uso](#🤖-uso)
- [🔰 Contribuição](#-contribuicao)
- [🎗 Licença](#-licenca)


---

## 📍 Visão Geral

<code>❯ Treinar sobre como consumir uma API com o JAVA e criar uma pagina html utilizando os dados consumidos para criar elementos do tipo lista </code>

---

## 👾 Funcionalidades

<code>
❯ Gerar uma requisiscao para o consumo de uma API
❯ Extrair dados dessa API e criar um parser que permita criar objetos a partir do response body obtido
❯ Criar elemento do tipo lista com essas instancias de objetos
❯ Criar uma pagina HTML e adicionar esses elementos utilizando um PrintWriter
</code>

---

## 📁 Estrutura do Projeto

```sh
└── desafio-7-days-of-code/
    ├── README.md
    ├── pom.xml
    └── src
        └── main
```

### 📂 Índice do Projeto
<details open>
	<summary><b><code>DESAFIO-7-DAYS-OF-CODE/</code></b></summary>
	<details> <!-- __root__ Submodule -->
		<summary><b>__root__</b></summary>
		<blockquote>
			<table>
			</table>
		</blockquote>
	</details>
	<details> <!-- src Submodule -->
		<summary><b>src</b></summary>
		<blockquote>
			<details>
				<summary><b>main</b></summary>
				<blockquote>
					<details>
						<summary><b>java</b></summary>
						<blockquote>
							<details>
								<summary><b>org</b></summary>
								<blockquote>
									<details>
										<summary><b>example</b></summary>
										<blockquote>
											<table>
											<tr>
												<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/Main.java'>Main.java</a></b></td>
												<td><code>❯ Main.Java </code></td>
											</tr>
											</table>
											<details>
												<summary><b>Request</b></summary>
												<blockquote>
													<table>
													<tr>
														<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/Request/ImdbApiClient.java'>ImdbApiClient.java</a></b></td>
														<td><code>❯public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String json = new ImdbApiClient("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMzBlOTY4YjJkYTg1YzhlZGNiNjI2YTM1ZmJjZTkzZiIsIm5iZiI6MTczNzM4MTE4Mi4zNzY5OTk5LCJzdWIiOiI2NzhlNTUzZWRiY2ZmMzNhOWM2NTU3YTYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0._jMtPU8KDGEj8gj-ytwUBJlYuA2K2TGKVq5lPqYiDzk").getBody();
        List<Movie> movies = new JsonParse(json).parseJson();
        PrintWriter writer = new PrintWriter("src/main/java/org/example/index.html");
        new HTMLGenerator(writer).generate(movies);
        writer.close();

    }
}</code></td>
													</tr>
													</table>
												</blockquote>
											</details>
											<details>
												<summary><b>parse</b></summary>
												<blockquote>
													<table>
													<tr>
														<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/parse/HTMLGenerator.java'>HTMLGenerator.java</a></b></td>
														<td><code>❯public class HTMLGenerator {


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
    }</code></td>
													</tr>
													<tr>
														<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/parse/JsonParse.java'>JsonParse.java</a></b></td>
														<td><code>❯ public class JsonParse {

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
    }</code></td>
													</tr>
													</table>
												</blockquote>
											</details>
											<details>
												<summary><b>domain</b></summary>
												<blockquote>
													<table>
													<tr>
														<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/domain/Movie.java'>Movie.java</a></b></td>
														<td><code>❯public Movie(String title, String urlImage, Double rating, Integer year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    public Movie(MoviesFromAPI movie) {
        this.title = movie.getTitle();
        this.urlImage = "https://image.tmdb.org/t/p/w500"+movie.getBackdropPath();
        this.rating = movie.getVoteAverage();
        this.year = Integer.valueOf(movie.getReleaseDate().substring(0,4));
    }
    // getter and setter ......
</code></td>
													</tr>
													<tr>
														<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/domain/Page.java'>Page.java</a></b></td>
														<td><code>❯ public class Page {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<MoviesFromAPI> results;

    public Page() {
    }

    public Page(int page, List<MoviesFromAPI> results) {
        this.page = page;
        this.results = results;
    } // getters and setters ....
    </code></td>
													</tr>
													<tr>
														<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/domain/MoviesFromAPI.java'>MoviesFromAPI.java</a></b></td>
														<td><code>❯ public class MoviesFromAPI implements Comparable<MoviesFromAPI> {
    /**
     * Aqui lemos o nome serializado no json e atribuimos a uma variavel que ira
     * corresponder o atributo do json
     * */
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("media_type")
    private String mediaType;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;
    
    // getters and setters ....
</code></td>
													</tr>
													</table>
												</blockquote>
											</details>
											<details>
												<summary><b>filesOut</b></summary>
												<blockquote>
													<table>
													<tr>
														<td><b><a href='https://github.com/igomarcelino/desafio-7-days-of-code/blob/master/src/main/java/org/example/filesOut/index.html'>index.html</a></b></td>
														<td><code>❯ HTML Structure</code></td>
													</tr>
													</table>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---
## 🚀 Primeiros Passos

### ☑️ Pré-requisitos

Antes de começar com o desafio-7-days-of-code, certifique-se de que o ambiente de execução atende aos seguintes requisitos:

- **Linguagem de Programação:** Java


### ⚙️ Instalação

Instale o desafio-7-days-of-code usando um dos seguintes métodos:

**Construa a partir do código-fonte:**

1. Clone o repositório desafio-7-days-of-code:
```sh
❯ git clone https://github.com/igomarcelino/desafio-7-days-of-code
```

2. Navegue para o diretório do projeto:
```sh
❯ cd desafio-7-days-of-code
```




### 🤖 Uso
Execute o desafio-7-days-of-code usando sua ide de preferencia




---

## 🔰 Contribuição

- **💬 [Participe das Discussões](https://github.com/igomarcelino/desafio-7-days-of-code/discussions)**: Compartilhe seus insights, forneça feedback ou faça perguntas.
- **🐛 [Reporte Problemas](https://github.com/igomarcelino/desafio-7-days-of-code/issues)**: Envie bugs encontrados ou registre pedidos de novas funcionalidades para o projeto `desafio-7-days-of-code`.
- **💡 [Envie Pull Requests](https://github.com/igomarcelino/desafio-7-days-of-code/blob/main/CONTRIBUTING.md)**: Revise PRs abertas e envie suas próprias PRs.

<details closed>
<summary>Diretrizes de Contribuição</summary>

1. **Faça um Fork do Repositório**: Comece fazendo um fork do repositório do projeto para a sua conta do GitHub.
2. **Clone Localmente**: Clone o repositório forkado para a sua máquina usando um cliente git.
   ```sh
   git clone https://github.com/igomarcelino/desafio-7-days-of-code
   ```
3. **Crie uma Nova Branch**: Sempre trabalhe em uma nova branch, dando a ela um nome descritivo.
   ```sh
   git checkout -b nova-funcionalidade-x
   ```
4. **Faça Suas Alterações**: Desenvolva e teste suas mudanças localmente.
5. **Comite Suas Alterações**: Faça commit com uma mensagem clara descrevendo suas atualizações.
   ```sh
   git commit -m 'Implementada nova funcionalidade x.'
   ```
6. **Envie para o GitHub**: Envie as alterações para o seu repositório forkado.
   ```sh
   git push origin nova-funcionalidade-x
   ```
7. **Envie um Pull Request**: Crie um PR contra o repositório original do projeto. Descreva claramente as mudanças e suas motivações.
8. **Revisão**: Uma vez que seu PR for revisado e aprovado, ele será mesclado na branch principal. Parabéns pela sua contribuição!
</details>

<details closed>
<summary>Gráfico de Contribuidores</summary>
<br>
<p align="left">
   <a href="https://github.com/igomarcelino/desafio-7-days-of-code/graphs/contributors">
      <img src="https://contrib.rocks/image?repo=igomarcelino/desafio-7-days-of-code">
   </a>
</p>
</details>

---

## 🎗 Licença

Sempre free


---

