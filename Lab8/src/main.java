import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

import static java.lang.Long.parseLong;

public class main {

    private float media;

    private Scanner leitor = null;

    private File arquivo = null;

    private String materia;


    private String nome = null;
    private Long DRE = null;
    private Float nota = null;

    Scanner scanner = new Scanner(System.in);


    private int linhasInvalidas = 0;
    private int linhasValidas = 0;


    public void main(String[] args){
        //coloquei o while para caso de FileNotFoundException poder voltar pro input do usuário
        while(true) {

            //Pega o input do usuário
            System.out.println("Qual o nome do arquivo:");
            String caminhoDoArquivo = scanner.nextLine();


            try {
                calcularMedia(caminhoDoArquivo);
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possível encontrar o aquivo.");
            } catch (ArquivoCorrompidoException e){
                //A própria excessão dá a mensagem de erro com o número de linhas inválidas
            }
            break;
        }
    }

    private float calcularMedia(String nomeDoArquivo) throws FileNotFoundException, ArquivoCorrompidoException{

        //Abre o arquivo
        File arquivo = new File(nomeDoArquivo);
        leitor = new Scanner(arquivo);

        Turma turma = new Turma();


        /*
        Organizei o arquivo para leitura como:
        Matéria:
        Nome:
        DRE:
        Nota:
        Nome:
        DRE:
        Nota:

         */
        //Checa se a primeira linha indica a matéria, caso não indique, falha a leitura
        try{
            PegarMateria.pegarMateria((String)leitor.next());
            this.materia = leitor.next();
        } catch (ArquivoInvalidoException e){
            e.printStackTrace();
        }
        //Passa preenchendo os campos
        while (leitor.hasNextLine()){
            switch (leitor.next()){
                case "Nome:":
                    this.nome = leitor.next();
                    linhasValidas++;
                    break;
                case "DRE:":
                    this.DRE = Long.parseLong(leitor.next());
                    linhasValidas++;
                    break;
                case "Float:":
                    this.nota = Float.parseFloat(leitor.next());
                    linhasValidas++;
                    break;
                default:
                    this.DRE = null;
                    this.nome = null;
                    this.nota = null;
                    linhasInvalidas++;
            }
            if(DRE != null && nome != null && nota != null) {
                //Cria um aluno preenchendo a turma e reseta os campos para que o if faça sentido
                turma.adicionarAluno(nome, DRE, nota, materia);
                this.DRE = null;
                this.nome = null;
                this.nota = null;
            }
        }
        if (linhasInvalidas > linhasValidas){
            throw new ArquivoCorrompidoException(linhasInvalidas);
        }

        leitor.close();

        System.out.println("A maior nota foi do: " + turma.maiorNota(materia).getNome());
        System.out.println("Passaram: " + turma.quantosAprovados(materia) + "alunos.");
        System.out.println("Reprovaram: " + turma.quantosReprovados(materia) + "alunos.");

            //

        return media;
    }
}
