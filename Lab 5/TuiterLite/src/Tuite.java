import java.util.*;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;
    private ArrayList<String> hashtags = new ArrayList<>();
    private T anexo = null;

    // hashtags?
    // objeto anexado?

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public void anexarAlgo(T anexo) {
        this.anexo = anexo;
    }

    public Object getAnexo() {
       return anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        Scanner leitor = new Scanner(texto);
        String palavra = null;
        while (leitor.hasNext()) {
            palavra = leitor.next();
            if (palavra.startsWith("#")) {
                hashtags.add(palavra);
            }
        }
        return hashtags;
    }
}
