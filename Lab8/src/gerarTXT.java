import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;


public class gerarTXT {

    private static final int ITERACOES = 100;
    private static final long DREMAXIMO = 900000000L;

    static String nome = null;

    static long DRE;

    static float nota;

    static Scanner input = new Scanner(System.in);

    static String materia = null;


    public static void main(String[] args) {
        try {
            gerarTXT.escrever();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escrever() throws IOException {
        FileWriter escrever = null;
        File ler = null;
        Scanner arquivo = null;
        try {
            escrever = new FileWriter("notas.txt");
            ler = new File("lista.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Matéria: ");

        materia = input.nextLine();

        escrever.write("Matéria: " + materia + "\n");

        Random aleatorio = new Random();

        //Achei elegante, mas infelizmente não funcionou porque escrevia com vírgulas e quebrou o meu parseFloat
        //DecimalFormat df2 = new DecimalFormat("#.##");

        int parteInteira;

        int parteDecimal;

        for (int i = 0; i < ITERACOES; i++) {
            nome = gerarNomeAleatorio(ler);
            escrever.write("Nome: " + nome + "\n");
            DRE = Math.abs(aleatorio.nextInt()) % DREMAXIMO;
            escrever.write("DRE: " + (100000000 + DRE) + "\n");
            nota = 10 * aleatorio.nextFloat();
            parteInteira = (int) nota;
            nota = nota * 100;
            parteDecimal = (int) nota % 100;




            escrever.write("Nota: " + parteInteira + "." + parteDecimal + "\n");

        }


        escrever.close();

    }

    private static String gerarNomeAleatorio(File f) throws FileNotFoundException {
        String nomeAleatorio = null;
        Random aleatorio = new Random();
        int n = 0;
        for (Scanner scan = new Scanner(f); scan.hasNext(); ) {
            n++;
            String linha = scan.nextLine();
            if (aleatorio.nextInt(n) == 0) {
                nomeAleatorio = linha;
            }
        }
        return nomeAleatorio;
    }
}
