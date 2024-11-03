package ejercicio_4;

import ejercicio_2.model.Set;
import ejercicio_2.model.Stack;

public class Main {
    public static void main(String[] args) {
        /**
         * SET
         */

        // Crear un Set usando el patrón Builder
        Set<Integer> set = new Set.Builder<Integer>()
                .add(1)
                .add(2)
                .add(3)
                .add(3)
                .add(3)// Validando que no inserte ek mismo elemento varias veces
                .build();

        System.out.println("Set 1:---- Usando el patrón Builder: add() ");
        for (Integer item : set) {
            System.out.print(item + " ");
        }

        // Crear otro Set e incluir el original usando addAll
        Set<Integer> set2 = new Set.Builder<Integer>()
                .add(0)
                .addAll(set) // Agrega todos los elementos de set
                .add(4)
                .build();

        System.out.println("\nSet 2:---- Usando el patrón Builder: addAll()");
        // Set 2: GenericSet: [0, 1, 2, 3, 4]
        for (Integer item : set2) {
            System.out.print(item + " ");
        }

        /**
         * STACK
         */

        System.out.println();
        // Crear una pila usando el patrón Builder
        Stack<Integer> stack = new Stack.Builder<Integer>()
                .add(1)
                .add(2)
                .add(3)
                .build();

        System.out.println("Stack 1:---- Usando el patrón Builder: add() " + stack);

        // Crear otra pila e incluir la original usando addAll
        Stack<Integer> stack2 = new Stack.Builder<Integer>()
                .add(0)
                .addAll(stack) // Agregar todos los elementos de la pila original
                .add(4)
                .build();

        System.out.println("Stack 2:---- Usando el patrón Builder: addAll() " + stack2); // Pila 2: Stack: [0, 1, 2, 3, 4]

        // Verifica la operación de pop
        System.out.println("Elemento en el tope de la pila original: " + stack.pop()); // Elemento en el tope de la pila original: 3

    }
}
