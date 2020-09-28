import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class LojaVirtual {

    private String categoria;
    private float pesoEmGramas;
    private float preco;
    private String autor;
    private String titulo;
    private int quantidadeDePaginas;
    private int anoDePublicacao;
    private int numeroDePaginas;

    private char tamanho;
    private String cor;

    private int quantidadeEmEstoque;
    ArrayList<Livro> listaDeLivros = new ArrayList();
    ArrayList<Roupa> listaDeRoupas = new ArrayList();

    public void comprarLivro();
    public void comprarRoupa();

    public static void LojaVirtual(String caregoria){
        Scanner scaner = new Scanner(System.in);
        if(caregoria == "Comprar Livro"){
            System.out.println("Titulo do livro:");
            this.titulo = scaner.toString();
            comprarLivro(this.titulo);
        }
        else if(caregoria == "Comprar vestimenta"){
            System.out.println("Qual a ID da roupa:");
            long ID = scaner.nextLong();
            comprarRoupa(ID);
        }
        else if(caregoria == "Criar Livro"){
            criarLivro();
        }
        else if(caregoria == "Criar Vestimenta"){
            criarVestimenta();
        }
        }

    public void criarLivro(){
        Scanner scaner = new Scanner(System.in);
        System.out.println("Peso em gramas:");
        this.pesoEmGramas = scaner.nextFloat();
        System.out.println("Quantidade de páginas:");
        this.quantidadeDePaginas = scaner.nextInt();
        System.out.println("Preço:");
        this.preco = scaner.nextFloat();
        System.out.println("Autor:");
        this.autor = scaner.toString();
        System.out.println("Titulo:");
        this.titulo = scaner.toString();
        System.out.println("Ano de publicação:");
        this.anoDePublicacao = scaner.nextInt();
        System.out.println("Numero de páginas:");
        this.numeroDePaginas = scaner.nextInt();
        System.out.println("Quantidade em estoque:");
        this.quantidadeEmEstoque = scaner.nextInt();

        Livro novoLivro = new Livro(pesoEmGramas, quantidadeDePaginas, preco, autor, titulo, anoDePublicacao, numeroDePaginas,quantidadeEmEstoque);
        listaDeLivros.add(novoLivro);
    }
    public void criarVestimenta() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Cor:");
        this.cor = scaner.toString();
        System.out.println("Tamanho:");
        this.tamanho = scaner.next().charAt(0);
        System.out.println("Peso em gramas:");
        this.pesoEmGramas = scaner.nextFloat();
        System.out.println("Quantidade de páginas:");
        this.quantidadeDePaginas = scaner.nextInt();
        System.out.println("Preço:");
        this.preco = scaner.nextFloat();
        System.out.println("Quantidade em estoque:");
        this.quantidadeEmEstoque = scaner.nextInt();


        Roupa novaRoupa = new Roupa(pesoEmGramas,preco, tamanho, cor, quantidadeEmEstoque);
        listaDeRoupas.add(novaRoupa);
    }

    public void comprarLivro(String titulo){
        for(int i = 0;i < listaDeLivros.size(); i++){
            if(listaDeLivros(i).getTitulo() == titulo){
                listaDeLivros(i).compra();
            }
        }
    }
    public void comprarRoupa(long id){
        for(int i = 0;i < listaDeLivros.size(); i++){
            if(listaDeRoupas(i).getID() == ID){
                listaDeRoupas(i).compra();
            }
        }
    }
    }



/*
- Crie uma classe LojaVirtual, com os atributos que você julgar necessários,
e com os seguintes métodos públicos:
    --> getTamanhoEstoque() para dizer a quantidade total de produtos que há no estoque
        da loja (considerando todas as unidades de todos os produtos)
    --> getTamanhoEstoque(Produto produto) para dizer a quantidade de unidades
        do produto passado como parâetro que há no estoque
    --> public void incluirProdutoNoEstoque(Produto produto, int quantidade)
    --> public String efetuarVenda(Produto produto, int quantidade)
        i) verifica se o produto existe no estoque da loja e na quantidade desejada
           (se não existir, não faz nada)
        ii) chama o método privado receberPagamento(float valor), que retorna
            se o pagamento foi recebido com sucesso (um boolean)
        iii) atualiza o estoque da loja
        iv) retorna uma String representando o recibo da compra
    --> public getTotalValorVendas() que retorna o valor total
        de todas as vendas efetuadas pela loja
 */


