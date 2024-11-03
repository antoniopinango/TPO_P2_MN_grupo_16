package ejercicio_1;

import java.util.Stack;
import ejercicio_1.model.QueueOfStacks;

import static ejercicio_1.logic.Matrices.sumaMatrices;
import static ejercicio_1.logic.Matrices.traspuesta;
import static ejercicio_1.logic.Matrices.traza;

public class Main {
    public static void main(String[] args) {
        QueueOfStacks matrixA = new QueueOfStacks();
        QueueOfStacks matrixB = new QueueOfStacks();

        // Llenamos la matriz A
        Stack<Integer> stackA1 = new Stack<>();
        stackA1.push(3); // Elemento en (0, 0)
        stackA1.push(2); // Elemento en (0, 1)
        stackA1.push(1); // Elemento en (0, 2)
        matrixA.enqueue(stackA1);

        Stack<Integer> stackA2 = new Stack<>();
        stackA2.push(6); // Elemento en (1, 0)
        stackA2.push(5); // Elemento en (1, 1)
        stackA2.push(4); // Elemento en (1, 2)
        matrixA.enqueue(stackA2);

        Stack<Integer> stackA3 = new Stack<>();
        stackA3.push(9); // Elemento en (2, 0)
        stackA3.push(8); // Elemento en (2, 1)
        stackA3.push(7); // Elemento en (2, 2)
        matrixA.enqueue(stackA3);

        // Llenamos la matriz B
        Stack<Integer> stackB1 = new Stack<>();
        stackB1.push(7); // Elemento en (0, 0)
        stackB1.push(8); // Elemento en (0, 1)
        stackB1.push(9); // Elemento en (0, 2)
        matrixB.enqueue(stackB1);

        Stack<Integer> stackB2 = new Stack<>();
        stackB2.push(4); // Elemento en (1, 0)
        stackB2.push(5); // Elemento en (1, 1)
        stackB2.push(6); // Elemento en (1, 2)
        matrixB.enqueue(stackB2);

        Stack<Integer> stackB3 = new Stack<>();
        stackB3.push(1); // Elemento en (2, 0)
        stackB3.push(2); // Elemento en (2, 1)
        stackB3.push(3); // Elemento en (2, 2)
        matrixB.enqueue(stackB3);

        // la traza de matriz A
        int trazaA = traza(matrixA);
        System.out.println("Traza de la Matriz A: " + trazaA); // 1 + 5 + 9 = 15

        // Calcular la traspuesta de A
        QueueOfStacks transpuestaA = traspuesta(matrixA);
        System.out.println("Traspuesta de la Matriz A:");
        for (int i = 0; i < transpuestaA.size(); i++) {
            Stack<Integer> stack = transpuestaA.getStack(i);
            for (int j = 0; j < stack.size(); j++) {
                System.out.print(stack.get(stack.size() - 1 - j) + " ");
            }
            System.out.println(); // Nueva línea para cada fila
        }

        // Sumar las matrices A y B
        QueueOfStacks suma = sumaMatrices(matrixA, matrixB);
        System.out.println("Suma de las Matrices A y B:");
        for (int i = 0; i < suma.size(); i++) {
            Stack<Integer> stack = suma.getStack(i);
            for (int j = 0; j < stack.size(); j++) {
                System.out.print(stack.get(stack.size() - 1 - j) + " "); // Mostrar los elementos
            }
            System.out.println(); // Nueva línea para cada fila
        }
    }
}
