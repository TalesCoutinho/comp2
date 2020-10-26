import java.util.*;

public class Turma {
    //Um hashmap que compõe a turma com alunos, sendo a key o nome do aluno e o value o objeto Aluno
    HashMap<String,Aluno> alunos = new HashMap<>();

    private Float maiorNota = 0.000f;

    private Aluno melhorAluno = null;

    public Turma(){

    }

    public void adicionarAluno(String nome, Long DRE, Float nota, String materia){
        Aluno aluno = new Aluno(nome,DRE);
        aluno.setNovaNota(materia, nota);
        alunos.put(nome, aluno);
    }
    //itera pelo HashMap procurando a maior nota. Encontrei esse pedaço de código no StackOverflow e achei que fazia muito sentido
    //e era bem elegante, por isso usei.
    public Aluno maiorNota(String materia){
        for(Map.Entry<String,Aluno> entry : alunos.entrySet()){
            String key = entry.getKey();
            Aluno value = entry.getValue();
            if((Float) value.getNota(materia) > maiorNota){
                maiorNota = value.getNota(materia);
                melhorAluno = value;
            }
        }
        return melhorAluno;
        }


    public float media(String materia){
        float contador = 0;
        for(Map.Entry<String,Aluno> entry : alunos.entrySet()){
            String key = entry.getKey();
            Aluno value = entry.getValue();
            contador += value.getNota(materia);
        }
        return contador/alunos.size();
    }


    //usa a mesma iteração do método maior nota, mas com a finalidade de contar os alunos reprovados.
    public int quantosReprovados(String materia){
        int reprovados = 0;
        for(Map.Entry<String,Aluno> entry : alunos.entrySet()){
            String key = entry.getKey();
            Aluno value = entry.getValue();
            if(value.getNota(materia) < 5.00){
                reprovados++;
            }
            }
        return reprovados;
        }


    //não queria copiar o método de cima e mudar um sinal, mas achei que criar uma classe que fizesse essa operação fosse demais.
    public int quantosAprovados(String materia){
        int aprovados = 0;
        for(Map.Entry<String,Aluno> entry : alunos.entrySet()){
            String key = entry.getKey();
            Aluno value = entry.getValue();
            if(value.getNota(materia) > 5.00){
                aprovados++;
            }
        }
        return aprovados;
    }




}
