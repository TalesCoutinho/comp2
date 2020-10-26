public class ArquivoCorrompidoException extends Exception{
    public ArquivoCorrompidoException(int numeroDeLinhas) {
        System.out.println("Esse arquivo está corrompido." + numeroDeLinhas);
    }
}
