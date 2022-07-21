public enum EndpointApi {
    
    IMDB_TOP250_MOVIES("https://alura-imdb-api.herokuapp.com/movies", new ExtratorDeConteudoDoIMDB()),
    IMDB_MOST_POPULAR_MOVIES("https://api.mocki.io/v2/549a5d8b/MostPopularMovies", new ExtratorDeConteudoDoIMDB()),
    NASA_APOD("https://api.nasa.gov/planetary/apod?api_key=<>&start_date=2022-07-01&end_date=2022-07-05", new ExtratorDeConteudoDaNasa());
    private String url;
    private ExtratorDeConteudo extrator;

    EndpointApi(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }

}
