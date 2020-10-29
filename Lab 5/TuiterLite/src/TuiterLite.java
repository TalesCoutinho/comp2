import java.util.*;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite<T> {

    public static int TAMANHO_MAXIMO_TUITES = 120;

    private HashMap<String, Usuario> usuariosCadastrados = new HashMap<>();

    private HashMap<String, Integer> hashtags = new HashMap<>();

    private Object anexo = null;


    public TuiterLite(){
        //ToDo implement me!!!
    }

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * Se o email informado já estiver em uso, não faz nada e retora null.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {
        if(!usuariosCadastrados.containsKey(email)){
            usuariosCadastrados.put(email, new Usuario(nome, email));
        }
        return new Usuario(nome,email);
    }


    /**
     * Tuíta algo, retornando o objeto Tuíte criado.
     * Se o tamanho do texto exceder o limite pré-definido, não faz nada e retorna null.
     * Se o usuário não estiver cadastrado, não faz nada e retorna null.
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {
        if(texto.length() > TAMANHO_MAXIMO_TUITES || !usuariosCadastrados.containsKey(usuario.getEmail())){
            return null;
        }
        Tuite tuite = new Tuite(usuario, texto);
        Integer contador;
        for(Object a : tuite.getHashtags()){
            contador = hashtags.get(a);
            if(contador == null){
                hashtags.put((String) a, 1);
            }else{
                hashtags.put((String) a, contador + 1);
            }
        }
        usuario.adicionarTuite();
        return tuite;
    }



    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        String hashtagMaisUsada = null;
        Integer contador = 0;
        for (String a: hashtags.keySet()){
            if(hashtags.get(a) > contador){
                contador = hashtags.get(a);
                hashtagMaisUsada = a;
            }
        }
        return hashtagMaisUsada;
    }
}
