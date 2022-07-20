import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        // String imdbPublicKey = rb.getString("imdb_public_key");
        // String URL = "https://alura-imdb-api.herokuapp.com/movies";
        String URL = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
        URI endereco = URI.create(URL);        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair os dados (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados de 5 filmes
        var geradora = new GeradororaDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = montarUrl(filme.get("image"));
            String titulo = filme.get("title");
            
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";
    
            geradora.cria(inputStream, nomeArquivo, Float.parseFloat(filme.get("imDbRating")));
            System.out.println(titulo);
        
        }
    }  

    private static String montarUrl(String urlImagem) {
        // tratando a url da imagem
        if (urlImagem.contains("@")) {
            String extensaoImagem = urlImagem.substring(urlImagem.length()-4);
            int indiceExtensao = urlImagem.indexOf(extensaoImagem);
            int indiceCaracterArroba = urlImagem.lastIndexOf("@");

            String substring = urlImagem.substring(indiceCaracterArroba+1, indiceExtensao);
            String novaUrl = urlImagem.replace(substring, "");

            return novaUrl;
        }

        return urlImagem;
    }

}
