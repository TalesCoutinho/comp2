public class PegarMateria {

    public static void pegarMateria(String texto) throws ArquivoInvalidoException{
        if (texto != "Materia:") {
            throw new ArquivoInvalidoException();
        } else{
            return;
        }
    }
}
