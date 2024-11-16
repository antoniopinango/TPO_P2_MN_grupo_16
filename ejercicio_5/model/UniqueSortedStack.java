package ejercicio_5.model;

import ejercicio_2.model.Set;
import ejercicio_2.model.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class UniqueSortedStack {
    public static Stack<Integer> createUniqueSortedStack(Stack<Integer> originalStack) {
        // Usa un conjunto para almacenar elementos únicos
        Set<Integer> uniqueElements = new Set<>();

        // Desapilar elementos de la pila original y almacenarlos en el conjunto
        while (!originalStack.isEmpty()) {
            uniqueElements.add(originalStack.pop());
        }

        // Crear una lista a partir del conjunto y ordenarla
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (Integer item : uniqueElements) {
            sortedList.add(item);
        }
        Collections.sort(sortedList);

        // Crear una nueva pila para los elementos ordenados
        Stack<Integer> sortedStack = new Stack<>();

        // Apilar los elementos de la lista ordenada
        for (int i = sortedList.size() - 1; i >= 0; i--) {
            sortedStack.push(sortedList.get(i));
        }

        return sortedStack;
    }
}




/*
 * Complejidad Computacional:

 * Cada operación de add() del conjunto tiene una complejidad de O(1) en promedio. Por lo tanto,
 * recorrer todos los elementos de la pila original para agregarlos al conjunto tiene una complejidad de O(n), donde n es el número de elementos en la pila original.

 * Ordenar la lista: La complejidad de ordenar la lista de elementos únicos es O(m log m), donde m es el número de elementos únicos.

 * Apilar elementos ordenados: Colocar elementos de la lista ordenada a la nueva pila tiene una complejidad de O(m).

 *  O(n) + O(m log m) + O(m) = O(n + m log m)
 *  O(n + nlogn)
 *  O(nlogn)
 */
