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



    private int linhasInvalidas = 0;
    private int linhasValidas = 0;


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //coloquei o while para caso de FileNotFoundException poder voltar pro input do usuário
        while(true) {

            //Pega o input do usuário
            System.out.println("Qual o nome do arquivo:");
            String caminhoDoArquivo = scanner.nextLine();


            try {
                calcularMedia(caminhoDoArquivo);
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possível encontrar o aquivo.");
                continue;
            } catch (ArquivoCorrompidoException e){
                //A própria excessão dá a mensagem de erro com o número de linhas inválidas
                continue;
            }
            break;
        }
    }

    private static void calcularMedia(String nomeDoArquivo) throws FileNotFoundException, ArquivoCorrompidoException{

         float media;

         String nome = null;
         Long DRE = null;
         Float nota = null;



         int linhasInvalidas = 0;
         int linhasValidas = 0;
        String materia = null;
        Scanner leitor = null;
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
            materia = leitor.next();
        } catch (ArquivoInvalidoException e){
            e.printStackTrace();
        }
        //Passa preenchendo os campos
        String a = null;
        try {
            while (leitor.hasNextLine()) {
                a = leitor.next();

                switch (a) {
                    case "Nome:":
                        nome = leitor.next();
                        linhasValidas++;
                        break;
                    case "DRE:":
                        DRE = Long.parseLong(leitor.next());
                        linhasValidas++;
                        break;
                    case "Nota:":
                        nota = Float.parseFloat(leitor.next());
                        linhasValidas++;
                        break;
                    default:
                        if (!a.equals("Nome:") || !a.equals("DRE") || !a.equals("Nota")) {
                            DRE = null;
                            nome = null;
                            nota = null;
                            linhasInvalidas++;
                        }
                }
                if (DRE != null && nome != null && nota != null) {
                    //Cria um aluno preenchendo a turma e reseta os campos para que o if faça sentido
                    turma.adicionarAluno(nome, DRE, nota, materia);
                    DRE = null;
                    nome = null;
                    nota = null;
                }
            }
        } catch (Exception e){
        linhasInvalidas++;
    }
        if (linhasInvalidas > linhasValidas){
            throw new ArquivoCorrompidoException(linhasInvalidas);
        }

        leitor.close();

        System.out.println("A media da turma foi: "+ turma.media(materia));
        System.out.println("A maior nota foi dx: " + turma.maiorNota(materia).getNome());
        System.out.println("Passaram: " + turma.quantosAprovados(materia) + " alunos.");
        System.out.println("Reprovaram: " + turma.quantosReprovados(materia) + " alunos.");

        return;
    }
}
