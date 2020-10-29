import java.util.*;


public class CalculadorIntersecaoEsperto extends CalculadorIntersecao<Integer> {

    HashSet<Integer> listaComparacao = new HashSet<>();

    @Override
    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {
        int contagem = 0;
        for(Integer a:lista2){
            listaComparacao.add(lista2.get(contagem));
            contagem++;
        }
        contagem = 0;
        for (Integer a:lista1){
            if(listaComparacao.contains(a)){
                contagem++;
            }
        }
        return contagem;
    }
}
