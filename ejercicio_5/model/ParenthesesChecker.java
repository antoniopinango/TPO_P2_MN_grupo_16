package ejercicio_5.model;

import ejercicio_2.model.Stack;

// Clase para verificar paréntesis balanceados
public class ParenthesesChecker {

    public static boolean areParenthesesBalanced(String expression) {
        // Pila para almacenar los paréntesis
        Stack<Character> stack = new Stack<>();

        // Recorrer la expresión
        for (char c : expression.toCharArray()) {
            // Ignorar comillas simples y dobles
            if (c == '"' || c == '\'') {
                continue; // Ignorar y continuar
            }
            // Si se encuentra un paréntesis de apertura, incluirlo en la pila
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Si se encuentra un paréntesis de cierre, verificar
            else if (c == ')' || c == '}' || c == ']') {
                // Si la pila está vacía, no hay un paréntesis de apertura correspondiente
                if (stack.isEmpty()) {
                    return false;
                }
                // Verificar que el paréntesis de cierre coincida con el de apertura
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }

        // En la final, la pila debe estar vacía para que todos los paréntesis sean balanceados
        return stack.isEmpty();
    }

    // Metodo auxiliar para verificar si los paréntesis coinciden
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

}
