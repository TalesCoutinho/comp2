import java.util.ArrayList;
import java.util.Random;

public class Album {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%
    private final int totalFigurinhas;
    private final int quantFigurinhasPorPacotinho;
    private       int numeroDePacotinhosRecebidos = 0;
    ArrayList<Integer> listaDeFigurinhas = new ArrayList(); //lista com a quantidade de figurinhas em cada posição

    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhas = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        for(int i = 0; i < totalFigurinhas; i++){
            listaDeFigurinhas.add(0); //só pra não ter problema de valor lixo e garantir que a lista vai ter o tamanho do álbum
        }

    }

    //Dei um overwrite nesse método porque tava tendo problemas com uns testes
    //Agora, se não receber um valor de posição, ele assume um valor aleatório dentro do número de figurinhas do álbum
    public void receberNovoPacotinho() {
        numeroDePacotinhosRecebidos++;
        Random index = new Random();
        for (int i = 0; i < quantFigurinhasPorPacotinho; i++) {
            Figurinha figurinha = new Figurinha(index.nextInt(totalFigurinhas)); //Cria novas figurinhas e indexa elas na lista
            int contagem = listaDeFigurinhas.get(figurinha.getPosicao()) + 1;
            listaDeFigurinhas.set(figurinha.getPosicao(), contagem);
        }
    }

    public void receberNovoPacotinho(Figurinha[] figurinha) {
        numeroDePacotinhosRecebidos++;
        for (int i = 0; i < quantFigurinhasPorPacotinho; i++) {
            int contagem = listaDeFigurinhas.get(figurinha[i].getPosicao()) + 1;
            listaDeFigurinhas.set(figurinha[i].getPosicao(), contagem);
        }
    }

    public int getTotalPacotinhosRecebidos() {
        return numeroDePacotinhosRecebidos;
    }

    /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarFigurinhasRestantes() {
        if (getQuantFigurinhasFaltando() / totalFigurinhas <= PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR){
            for (int i = 0; i < listaDeFigurinhas.size(); i++){
                if (listaDeFigurinhas.get(i) == 0) listaDeFigurinhas.set(i, 1);
            }
        }
        else System.out.println("Você precisa ter 90% do álbum completo para encomendar as figurinhas faltantes");
    }

    public boolean possuiFigurinhaColada(int posicao) {
        if(listaDeFigurinhas.get(posicao) == 0) return false;
        else return true;
    }

    public boolean possuiFigurinhaColada(Figurinha figurinha) {
        if(listaDeFigurinhas.get(figurinha.getPosicao()) == 0) return false;
        else return true;
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        if(listaDeFigurinhas.get(posicao) <= 1) return false;
        else return true;
    }

    public boolean possuiFigurinhaRepetida(Figurinha figurinha) {  // overload
        return possuiFigurinhaRepetida(figurinha.getPosicao());
    }

    public int getQuantFigurinhasColadas() {
        int coladas = 0;
        for (int i = 0; i < listaDeFigurinhas.size(); i++){
            if (listaDeFigurinhas.get(i) > 0) coladas++;
        }
        return coladas;
    }

    public int getQuantFigurinhasRepetidas() {
        int repetidas = 0;
        for (int i = 0; i < listaDeFigurinhas.size(); i++){
            if (listaDeFigurinhas.get(i) > 1) repetidas += listaDeFigurinhas.get(i) - 1;
        }
        return repetidas;
    }

    public int getQuantFigurinhasFaltando() {
        int faltantes = 0;
        for (int i = 0; i < listaDeFigurinhas.size(); i++){
            if (listaDeFigurinhas.get(i) == 0) faltantes++;
        }
        return faltantes;
    }

    public int getTamanhoDoAlbum(){return totalFigurinhas;}
}
