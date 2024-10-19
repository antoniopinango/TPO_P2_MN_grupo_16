package src.logic;

import java.util.Stack;
import src.model.QueueOfStacks;

public class Matrices {


    public static int traza(QueueOfStacks queueOfStacks) {
        int n = queueOfStacks.size();
        int trazaSum = 0;
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = queueOfStacks.getStack(i);
            trazaSum += stack.get(stack.size() - 1 - i); // Obtenemos el último elemento de la pila
        }
        return trazaSum;
    }

    public static QueueOfStacks traspuesta(QueueOfStacks queueOfStacks) {
        int n = queueOfStacks.size();
        QueueOfStacks transposed = new QueueOfStacks();

        // Inicializamos las pilas de la matriz transpuesta con la cantidad de pilas que tiene la matriz original
        for (int i = 0; i < n; i++) {
            transposed.enqueue(new Stack<>());
        }

        // Llenamos la matriz transpuesta
        for (int i = 0; i < n; i++) {
            Stack<Integer> originalStack = queueOfStacks.getStack(i);
            Integer[] tempArray = new Integer[originalStack.size()];

            // Copiar elementos de la pila original a un array temporal
            for (int j = 0; j < originalStack.size(); j++) {
                tempArray[j] = originalStack.get(originalStack.size() - 1 - j); // Acceder desde el top hacia abajo
            }

            // Colocar las filas en columnas |-
            for (int j = originalStack.size(); j > 0;  j--) {
                Stack<Integer> transposedStack = transposed.getStack(j-1);
                transposedStack.push(tempArray[j-1]);
            }
        }
        return transposed;
    }

    public static QueueOfStacks sumaMatrices(QueueOfStacks queueOfStacksA, QueueOfStacks queueOfStacksB) {
        int n = queueOfStacksA.size();
        QueueOfStacks suma = new QueueOfStacks();

        for (int i = 0; i < n; i++) {
            Stack<Integer> nuevaPila = new Stack<>();
            Stack<Integer> stackA = queueOfStacksA.getStack(i);
            Stack<Integer> stackB = queueOfStacksB.getStack(i);

            for (int j = 0; j < stackA.size(); j++) {
                int sumaA = stackA.get(stackA.size() - 1 - j); // Obtener el elemento desde la parte superior de la pila
                int sumaB = stackB.get(stackB.size() - 1 - j);
                nuevaPila.push(sumaA + sumaB); // Sumar los elementos
            }
            suma.enqueue(nuevaPila);
        }
        return suma;
    }
}
