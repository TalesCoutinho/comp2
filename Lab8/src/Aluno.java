import java.util.HashMap;

public class Aluno {
    //Classe simples pra estruturar o aluno, apenas com um HashMap para que o aluno possa ter notas em diferentes matérias
    //e alguns identificadores, como nome e DRE.
    private HashMap<String, Float> notas = new HashMap<>();
    final private String nome;
    final private long DRE;


    public Aluno(String nome, long dre){
        this.nome = nome;
        this.DRE = dre;
    }

    public String getNome() {
        return nome;
    }

    public void setNovaNota(String materia, float nota){
        notas.put(materia, nota);
    }

    public Float getNota(String materia){
        return notas.get(materia);
    }
    }


