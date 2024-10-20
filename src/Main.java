package src;

import java.util.Set;
import src.model.GenericSet;
import src.model.Stack;

import static src.logic.utils.GenericUtils.copySet;
import static src.logic.utils.GenericUtils.invertStack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack original:");
        while(!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }

        // Rellenar el stack nuevamente para la demostración
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Invertir el stack
        invertStack(stack);
        System.out.println("\nStack invertido:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        // Ejemplo de uso para copiar un set
        GenericSet<String> originalSet = new GenericSet<>();
        originalSet.add("A");
        originalSet.add("B");
        originalSet.add("C");

        Set<String> copiedSet = copySet(originalSet);
        System.out.println("\nSet copiado:");
        for (String item : copiedSet) {
            System.out.print(item + " ");
        }

    }
}
