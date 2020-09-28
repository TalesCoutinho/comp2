public class Produto {

    private static long nextSeqNum = 1;

    protected final long id;  // identificador único (sequencial) deste objeto

    private final float pesoEmGramas;

    private float precoEmReais;

    private String categoria;

    private int quantidadeEmEstoque;

    public Produto(float preco, float pesoEmGramas, String categoria) {

        this.id = nextSeqNum++;
        this.precoEmReais = preco;
        this.categoria = categoria;
        this.pesoEmGramas = pesoEmGramas;
    }


    public long getId() {
        return this.id;
    }


}

/*
- Crie uma classe Produto, com atributos:
    --> id (final long)
    --> pesoEmGramas (int)
    --> preçoEmReais (float)
    --> categoria (String)
    --> quantidadeEmEstoque (int)
 */
