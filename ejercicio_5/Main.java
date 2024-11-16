package ejercicio_5;

import ejercicio_2.model.Stack;
import ejercicio_5.model.Coordinate;
import ejercicio_5.model.MonteCarlo;
import java.util.Random;

import static ejercicio_5.model.CesarCipher.decrypt;
import static ejercicio_5.model.CesarCipher.encrypt;
import static ejercicio_5.model.MonteCarlo.isInsideCircle;
import static ejercicio_5.model.ParenthesesChecker.areParenthesesBalanced;
import static ejercicio_5.model.UniqueSortedStack.createUniqueSortedStack;

public class Main {
    public static void main(String[] args) {
        /**
         * Generar una nueva pila sin elementos repetidos y ordenados
         * */
        Stack<Integer> originalStack = new Stack<>();
        originalStack.push(4);
        originalStack.push(2);
        originalStack.push(3);
        originalStack.push(1);
        originalStack.push(2); // Elemento repetido
        originalStack.push(5);

        // Generar una nueva pila sin elementos repetidos y ordenados
        Stack<Integer> uniqueSortedStack = createUniqueSortedStack(originalStack);

        // Imprimir la nueva pila
        System.out.println("Pila ordenada y sin duplicados:");
        while (!uniqueSortedStack.isEmpty()) {
            System.out.print(uniqueSortedStack.pop() + " ");
        }



        /**
         *  diccionario que tenga como clave cada letra del alfabeto español y como valor cada frecuencia asociada
         *
         *  Cree una String en español de mas de 500 caracteres, y que tenga aplicado un cifrado César
         *  Desarrolle un algoritmo que desencripte la String en base a la frecuencia de sus caracteres.
         * */

        System.out.println("\n");

        String originalText = "Este es un texto de ejemplo en español para demostrar el cifrado César.";

        // Cifrar texto
        String encryptedText = encrypt(originalText, 3); // Desplazamiento de 3
        System.out.println("Texto cifrado: " + encryptedText);

        // Desencriptar texto
        String decryptedText = decrypt(encryptedText, 3);
        System.out.println("Texto desencriptado: " + decryptedText);


        /**
         *  paréntesis balanceados
         *
         */

        System.out.println();

        // Ejemplos de pruebas
        String test1 = "(a + b) + (c - d)";
        String test2 = "{a + [b - (c * d)]} + e";
        String test3 = "(a + b) + (c - d)]";  // Desbalanceado
        String test4 = "([{'a': 'value'}])";   // Ignorar comillas y balanceado
        String test5 = "a + b + '((c-d) + e)'"; // Ignorar comillas simples

        System.out.println("Test 1: " + areParenthesesBalanced(test1)); // true
        System.out.println("Test 2: " + areParenthesesBalanced(test2)); // true
        System.out.println("Test 3: " + areParenthesesBalanced(test3)); // false
        System.out.println("Test 4: " + areParenthesesBalanced(test4)); // true
        System.out.println("Test 5: " + areParenthesesBalanced(test5)); // true


        /**
         *
         *TDA Montecarlo
         */


        System.out.println();

        MonteCarlo montecarlo = new MonteCarlo();
        Random rand = new Random();

        // Generar 1000 coordenadas aleatorias
        while (montecarlo.getCount() < 1000) {
            double x = rand.nextDouble(); // Generar un número aleatorio entre 0.0 y 1.0
            double y = rand.nextDouble();
            Coordinate coord = new Coordinate(x, y);
            montecarlo.addCoordinate(coord);
        }

        // Calcular la aproximación de π
        int pointsInsideCircle = 0;
        for (Coordinate coord : montecarlo.getCoordinates()) {
            if (isInsideCircle(coord)) {
                pointsInsideCircle++;
            }
        }

        // Aproximación de π
        double piApproximation = 4.0 * pointsInsideCircle / montecarlo.getCount();

        System.out.println("Número de puntos dentro de la circunferencia: " + pointsInsideCircle);
        System.out.println("Aproximación de π: " + piApproximation);
    }
}
