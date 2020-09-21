import java.util.Random;

public class Figurinha {

    private final int posicao;
    private final String urlImagem;


    public Figurinha(int posicao) {
        Random url = new Random();
        this.posicao = posicao;
        this.urlImagem = new String("https://youtu.be/grEKMHGYyns?t=" + url.nextInt(17000));
    }


    /**
     * Indica a posição, no álbum, que esta figurinha deve ocupar.
     *
     * @return Um int dizendo a posição da figurinha
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * Retorna a URL de onde a imagem associada a esta figurinha deverá ser baixada.
     *
     * @return uma String com o endereço desejado
     */
    public String getUrlImagem() {
        return urlImagem;
    }
}
