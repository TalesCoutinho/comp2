public class Produto {

    private static long nextSeqNum = 1;

    private final int pesoEmGramas;

    private int preçoEmReais;

    private String categoria;

    private int quantidadeEmEstoque;

    protected final long id;  // identificador único (sequencial) deste objeto

    public Produto() {
        this.id = nextSeqNum++;
    }

    public long getId() {
        return this.id;
    }
}
