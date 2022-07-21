import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json) {
        // extrair os dados
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        listaDeAtributos.forEach(elemento -> {
            String titulo = elemento.get("title");
            String urlImagem = elemento.get("url");

            var conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        });

        return conteudos;
    }

}
