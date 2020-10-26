public class PegarMateria {

    public static void pegarMateria(String texto) throws ArquivoInvalidoException{
        if (texto.equals("Matéria:")) {
            return;
        } else{
            throw new ArquivoInvalidoException();
        }
    }
}
