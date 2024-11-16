package ejercicio_2.utils;

import ejercicio_2.model.Set;
import ejercicio_2.model.Stack;

public class GenericUtils {

    public GenericUtils() {
    }

    // 1. Función que invierte los elementos de un Stack genérico
    public static <T> void invertStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        T topElement = stack.pop(); // Sacar el elemento superior
        invertStack(stack); // Recursivamente invertir el resto del stack
        insertAtBottom(stack, topElement); // Insertar el elemento al fondo
    }

    private static <T> void insertAtBottom(Stack<T> stack, T item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            T topElement = stack.pop(); // Sacar el elemento superior
            insertAtBottom(stack, item); // Llamar recursivamente
            stack.push(topElement); // Regresar el elemento superior
        }
    }

    // 2. Función que copia un Set genérico
    public static <T> Set<T> copySet(Set<T> originalSet) {
        Set<T> newSet = new Set<>();
        for (T item : originalSet) {
            newSet.add(item);
        }
        return newSet;
    }
}