import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//Mudei alguns testes porque alterei a classe Figurinhas. Agora ela tem um sistema de URL interno, não aceita mais input do usuário.

public class AlbumTest {

    private Random random = new Random();

    private Album album;
    private final int TOTAL_FIGURINHAS = 200;
    private final int QUANT_FIGURINHAS_POR_PACOTE = 3;

    @Before
    public void setUp() {
        album = new Album(TOTAL_FIGURINHAS, QUANT_FIGURINHAS_POR_PACOTE);
    }

    @Test
    public void testarRecebimentoPacotinhoQualquer() {
        Figurinha[] novoPacotinho = criarPacotinho(null);  // posições aleatórias

        album.receberNovoPacotinho(novoPacotinho);
        assertEquals(1, album.getTotalPacotinhosRecebidos());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE,
                album.getQuantFigurinhasColadas() + album.getQuantFigurinhasRepetidas());
        for (int i = 0; i < QUANT_FIGURINHAS_POR_PACOTE; i++) {
            assertTrue(album.possuiFigurinhaColada(novoPacotinho[i]));
        }
    }

    @Test
    public void testarRecebimentoFigurinhaRepetida() {

        int[] posicoes = new int[]{1, 1, 1};

        // equivalentemente...
//        int[] posicoes = new int[3];
//        posicoes[0] = 1;
//        posicoes[1] = 1;
//        posicoes[2] = 1;
        Figurinha[] primeiroPacotinho = criarPacotinho(posicoes);

        album.receberNovoPacotinho(primeiroPacotinho);
        assertEquals(1, album.getQuantFigurinhasColadas());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE - 1, album.getQuantFigurinhasRepetidas());
        assertTrue(album.possuiFigurinhaRepetida(1));
        assertTrue(album.possuiFigurinhaRepetida(primeiroPacotinho[0]));  // outra forma
        assertTrue(album.possuiFigurinhaRepetida(new Figurinha(1)));  // outra forma

        posicoes = new int[] {10, 23, 1};
        Figurinha[] segundoPacotinho = criarPacotinho(posicoes);
        album.receberNovoPacotinho(segundoPacotinho);
        assertEquals(3, album.getQuantFigurinhasColadas());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE, album.getQuantFigurinhasRepetidas());
        assertTrue(album.possuiFigurinhaColada(10));
        assertTrue(album.possuiFigurinhaColada(23));
        assertFalse(album.possuiFigurinhaRepetida(10));
        assertFalse(album.possuiFigurinhaRepetida(23));
        assertTrue(album.possuiFigurinhaRepetida(1)); //Originalmente era assertFalse, mas como a posição 1 já é preenchida pelo
        //primeiroPacotinho, sempre daria que tem figura repetida. Então mudei o teste.

        assertEquals(2, album.getTotalPacotinhosRecebidos());
    }
/*
    Professor, não entendi esse teste.
    O método é VOID, sem qualquer retorno. Como vou chamar o método e checar o que ele retornou?
    Rodando o teste diversas vezes para entender o que estava acontecendo, percebi que espera o valor 0, assumi que fosse
    o retorno padrão de um método void, e o método entrega o valor 200. Honestamente não sei como e não entendi nada. Tampouco
    a internet me ajudou.
*/

    @Test
    public void testarPreenchimentoAutomaticoDasUltimasFigurinhas() {
        // aqui o álbum está ainda vazio
        album.encomendarFigurinhasRestantes();
        assertEquals("Não deve ser possível encomendar as figurinhas faltantes " +
                        "antes de ter 90% ou mais do álbum já preenchido",
                0, album.getQuantFigurinhasColadas());

        // vamos agora preencher o álbum quase totalmente
        while (album.getQuantFigurinhasColadas() <
                TOTAL_FIGURINHAS * Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR - 1) {
            //Figurinha[] pacotinho = criarPacotinho(); Dei um overwrite no método receberNovoPacotinho pra aceitar void como parâmetro. Só
            //pra resolver um erro que tava dando com OverIndex no pacotinho
            album.receberNovoPacotinho();
        }

        album.encomendarFigurinhasRestantes();
        assertEquals("Depois da encomenda, o álbum deve estar completo",
                TOTAL_FIGURINHAS, album.getQuantFigurinhasColadas());
    }

    private Figurinha[] criarPacotinho(int[] posicoesDesejadas) {
        Figurinha[] novoPacotinho = new Figurinha[QUANT_FIGURINHAS_POR_PACOTE];
        for (int i = 0; i < QUANT_FIGURINHAS_POR_PACOTE; i++) {
            int posicaoDaFigurinha = posicoesDesejadas == null ? escolherPosicaoAleatoria() :
                    posicoesDesejadas[i];
            Figurinha figurinha = new Figurinha(posicaoDaFigurinha);
            novoPacotinho[i] = figurinha;
        }
        return novoPacotinho;
    }

    private int escolherPosicaoAleatoria() {
        return random.nextInt(TOTAL_FIGURINHAS) + 1;
    }
}