public class Livro extends Produto {

    private final String titulo;
    private final String autor;
    private final int anoDePublicacao;
    private final int quantPaginas;
    private int quantidadeEmEstoque;

    public Livro(float pesoEmGramas, int quantidadePaginas, float precoEmReais, String autor, String titulo, int anoDePublicacao, int nuemroDePaginas, int quantidadeEmEstoque){
        super(precoEmReais, pesoEmGramas, "Publicações");
        this.autor = autor;
        this.titulo = titulo;
        this.anoDePublicacao = anoDePublicacao;
        this.quantPaginas = nuemroDePaginas;
        this.quantidadeEmEstoque = quantidadeEmEstoque;

    }

    public String getTitulo(){return titulo;}

    public void compra(){quantidadeEmEstoque--;}

    @Override
    public String toString() {
        return String.format("Livro com id %d, contendo %d paginas",
                this.id, this.quantPaginas);

        // ou...
        //        return "Livro com id " + this.id + ", contendo " + quantPaginas;

    }
}

/*
- Crie uma classe Livro, herdando de Produto, com os seguintes atributos extras:
    --> titulo (final String)
    --> autor (final String)
    --> anoDePublicacao (final int)
    --> numeroDePaginas (final int)
    A categoria de qualquer livro deve ser automaticamente "Publicações"
 */
