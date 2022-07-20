import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradororaDeFigurinhas {
    
    void cria(InputStream inputStream, String nomeArquivo, float imdbRating) throws Exception {
        
        // leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics2D = (Graphics2D) novaImagem.getGraphics();
        graphics2D.drawImage(imagemOriginal, 0, 0, null);
        
        // configurar a fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 80);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.YELLOW);
        
        // escrever uma frase na nova imagem
        FontMetrics fm = graphics2D.getFontMetrics();
        String frase = "";
        
        if (imdbRating >= 8.5) {
            frase = "TOPZERA";
        } else if (imdbRating >= 7.5) {
            frase = "MUITO BOM";
        } else if (imdbRating >= 5.0) {
            frase = "MAIS OU MENOS";
        } else {
            frase = "NÃO RECOMENDO";
        }
        
        /* 
        Falha ao tentar contornar o texto

        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        var textLayout = new TextLayout(frase, font, fontRenderContext);

        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics2D.getTransform();
        transform.translate(posicaoXFrase, posicaoYFrase);
        graphics2D.setTransform(transform);
        
        var outlineStroke = new BasicStroke(largura * 0.004166f);
        graphics2D.setStroke(outlineStroke);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.draw(outline);
        graphics2D.setClip(outline);
        */
        
        int posicaoXFrase = (novaImagem.getWidth()/2)-(fm.stringWidth(frase)/2);
        int posicaoYFrase = novaAltura - 100;
        graphics2D.drawString(frase, posicaoXFrase, posicaoYFrase);

        // escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

    }

}
