import java.awt.*;

public class Usuario {

    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;

    private final String email;
    private String nome;
    private Image foto;
    private Integer quantidadeDeTuites = 0;

    // Pode ser INICIANTE, SENIOR ou NINJA
    private NivelUsuario nivel;

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
        this.nivel = NivelUsuario.INICIANTE;
    }

    @Override
    public String toString(){
        return nome;
    }

    @Override
    public boolean equals(Object outro){
        Usuario teste = (Usuario) outro;
        if(email.equals(teste.getEmail())){
            return true;
        } else return false;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    public void adicionarTuite(){
        quantidadeDeTuites++;
        switch ( quantidadeDeTuites){
            case MIN_TUITES_SENIOR:
                nivel = NivelUsuario.SENIOR;
                break;
            case MIN_TUITES_NINJA:
                nivel = NivelUsuario.NINJA;
                break;
        }
    }
}
