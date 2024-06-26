package Esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

//  ordini di importanza di log: TRACE < DEBUG < INFO < WARN < ERROR
// il logger di default è sempre DEBUG
// anche la root di default è DEBUG
// quelli inferiori a debug non vengono stampati

public class Main {
    static Logger logger = LoggerFactory.getLogger("logger1");

    public static void main(String[] args) {
        logger.info("Lancio dell'applicazione");
        risultato();
    }

    public static void risultato() {
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);
        int numero;
        int indice;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10) + 1;
        }

        System.out.println("Array casuale:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        try {
            do {
                System.out.println();
                System.out.println("------------------");

                System.out.println("Inserisci un numero (0 per terminare): ");
                numero = scanner.nextInt();
                scanner.nextLine();

                if (numero != 0) {
                    System.out.println("Inserisci a che indice vorresti inserire il numero (da 0 a 4): ");
                    indice = scanner.nextInt();

                    if (indice >= 0 && indice < array.length) {
                        array[indice] = numero;

                        System.out.println("-----------------------");
                        System.out.println("Nuovo stato dell'array:");
                        for (int num : array) {
                            System.out.print(num + " ");
                        }
                    } else {
                        throw new IndiceNonValidoException("Indice non valido. Chiusura in corso...");
                    }
                }

            } while (numero != 0);

            scanner.close();
            logger.info("Termine dell'applicazione");

        } catch (IndiceNonValidoException e) {
            System.out.println(e.getMessage());
        }
    }
}

