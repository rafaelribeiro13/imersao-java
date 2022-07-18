import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class App {

    private static final String ANSI_COR_TEXTO = "\u001b[37m";
    private static final String ANSI_COR_FUNDO = "\u001b[45m";
    private static final String ANSI_RESET = "\u001b[0m";
    private static final String ANSI_STAR = "\u2B50";
    private static final String ANSI_NEGRITO = "\u001b[1m";
    private static ResourceBundle rb = ResourceBundle.getBundle("configs", Locale.getDefault());

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String imdbPublicKey = rb.getString("imdb_public_key");
        String URL = "https://imdb-api.com/en/API/Top250Movies/" + imdbPublicKey;
        URI endereco = URI.create(URL);        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair os dados (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        int count = 0;
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.printf("%s%s%d%n", ANSI_COR_TEXTO, ANSI_NEGRITO, count);
            System.out.printf("Título: %s%s%n", ANSI_RESET, filme.get("title"));
            System.out.printf("%s%sPoster: %s%s%n", ANSI_COR_TEXTO, ANSI_NEGRITO, ANSI_RESET, filme.get("image"));
            System.out.printf("%s%s%sClassificação: %s%s%n", ANSI_COR_TEXTO, ANSI_NEGRITO, ANSI_COR_FUNDO, filme.get("imDbRating"), ANSI_RESET);

            // exibindo a classificação como estrelas
            String classificacaoImdb = filme.get("imDbRating");
            if (!classificacaoImdb.isEmpty() && classificacaoImdb != null) {
                int n = Math.round(Float.parseFloat(classificacaoImdb));
                
                for (int i = 0; i < n; i++) {
                    System.out.print(ANSI_STAR);
                }
            }

            // lendo classificação do usuário
            System.out.println();
            System.out.print(ANSI_COR_TEXTO + ANSI_NEGRITO + "Sua classificação: ");
            sc.nextDouble();

            System.out.print(ANSI_RESET);
            System.out.println();
            count++;
        }

        sc.close();
    }
}
