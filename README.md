# Imersão Java - Alura


![GitHub Org's stars](https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-brightgreen)

Esse projeto foi desenvolvido durante a Imersão Java oferecido pela Alura. O objetivo primário desse projeto foi consumir as API's de filmes do IMDB como Top250Movies, MostPopularMovies etc, e gerar Stickers para aplicativos de mensagens.

## Aula 01

Nesta aula, o objetivo foi consumir a API de filmes Top250Movies do IMDB e exibir no terminal os dados de cada filme como: Titulo, Url da imagem e Ranking. 

![Resultado Aula 01](https://user-images.githubusercontent.com/72167489/180615254-e942f05d-fd38-497c-8df2-ed181816eb10.png)

### Desafios concluidos nesta aula:

- Consumir outros Endpoints do IMDB.
- Estilizar a exibição dos dados dos filmes no terminal. 
- Externalizar a chave de acesso a API do IMDB (p.ex, um arquivo .properties). 
- Possibilidade do usuário avaliar cada filme.

## Aula 02

Nesta aula, o objetivo foi transformar as imagens dos filmes consumidos na API do IMDB em stickers com legenda.

![Resultado Aula 02](https://user-images.githubusercontent.com/72167489/180616931-8caaf4ac-4310-4fcb-a94b-3c5ab21bb56f.png)

### Desafios concluidos nesta aula:

- Ler a documentação da classe InputStream.
- Centralizar a legenda na figurinha.
- Criar diretório de saída das imagens.
- Tratar a url das imagens retornadas pela API do IMDB para pegar uma imagem maior ao invés de thumbnails.
- Fazer com que a legenda da figurinha seja personalizado de acordo com as classificações do IMDB.

## Aula 03

Nesta aula, o objetivo foi refatorar o código aplicando alguns dos principais conceitos da Orientação a Objetos `Encapsulamento e Polimorfismo` separando as reponsabilidades, tornando a aplicação mais flexível e legível. 

![Resultado Aula 03](https://user-images.githubusercontent.com/72167489/180619032-65baaa27-d19e-45b8-846e-22eceec099b3.png)

### Desafios concluidos nesta aula:

- Criar as próprias exceções.
- Usar recursos do Java 8 e posterior, como Streams e Lambdas, para mapear uma lista em uma outra.
- Criar um Enum que une, como configurações, a URL da API e o extrator utilizado.
