import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json) {
        // extrair os dados
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        listaDeAtributos.forEach(elemento -> {
            String titulo = elemento.get("title");
            String urlImagem = montarUrl(elemento.get("image"));

            var conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        });

        return conteudos;
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
