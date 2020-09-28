public class Roupa extends Produto {

    private final char tamanho;
    private final String cor;
    private int quantidadeEmEstoque;

    public Roupa(float pesoEmGramas, float precoEmReais, char tamanho, String cor, int quantidadeEmEstoque){
        super(precoEmReais, pesoEmGramas, "Vestimenta");
        this.cor = cor;
        this.tamanho = tamanho;
        this.quantidadeEmEstoque = quantidadeEmEstoque;

    }

    public void compra() {quantidadeEmEstoque--}
}

/*
- Crie uma classe Roupa, herdando de Produto, com os seguites atributos extras:
    --> tamanho (final char)  //  'p' 'm' 'g', etc.
    --> cor (String)
    A categoria de qualquer livro deve ser automaticamente "Vestuário"
 */