import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    // fiz isso pra testar algumas coisas intermediárias ao longo do desenvolvimento do sistema
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tamanhoDoAlbum = 0;
        int figuPorPacote = 0;

            System.out.println("Quantas figurinhas no álbum?");
            tamanhoDoAlbum = input.nextInt();
            System.out.println("Quantas figurinhas por pacote?");
            figuPorPacote = input.nextInt();


        Album principal = new Album(tamanhoDoAlbum, figuPorPacote);
        for (int i = 0; i < 100; i++) {
            principal.receberNovoPacotinho();
            System.out.println(principal.listaDeFigurinhas);
        }
/*
        Random random = new Random();
        int[] numeros = new int[20];

        for (int i = 0; i < 20; i++) {
            numeros[i] = random.nextInt();
        }
        for (int x : numeros) {  // ilustrando um "for each"
            System.out.println(x);*/
        }
    }

