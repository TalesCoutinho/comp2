import java.util.*;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;
    private HashMap<String, Integer> hashtags/

    // hashtags?
    // objeto anexado?

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public void anexarAlgo(Object anexo) {
        // ToDo IMPLEMENT ME!!!!
    }

    public Object getAnexo() {
        return null;  // ToDo IMPLEMENT ME!!!
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        return null;  // ToDo IMPLEMENT ME!!!
    }
}
