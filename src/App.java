import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        EndpointApi apiNasa = EndpointApi.NASA_APOD;
        ExtratorDeConteudo extrator = apiNasa.getExtrator();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(apiNasa.getUrl());

        // exibir e manipular os dados de 5 filmes
        List<Conteudo> listaDeConteudos = extrator.extraiConteudos(json);
        var geradora = new GeradororaDeFigurinhas();
        
        for (Conteudo conteudo : listaDeConteudos) {

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";
    
            geradora.cria(inputStream, nomeArquivo);
            System.out.println(conteudo.getTitulo());
        
        }

    }  

}
