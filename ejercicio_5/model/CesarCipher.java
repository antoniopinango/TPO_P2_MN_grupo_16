package ejercicio_5.model;

public class CesarCipher {
    // Alfabeto español incluyendo 'ñ'
    private static final String ALPHABET = "abcdefghijklmnñopqrstuvwxyz";
    private static final int ALPHABET_SIZE = ALPHABET.length();

    /**
     * Cifra una cadena usando el cifrado César.
     *
     * @param text  Texto a cifrar
     * @param shift Desplazamiento
     * @return Texto cifrado
     */
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                int index = ALPHABET.indexOf(lowerChar);
                if (index != -1) {
                    int newIndex = (index + shift) % ALPHABET_SIZE;
                    char newChar = ALPHABET.charAt(newIndex);
                    result.append(Character.isUpperCase(c) ? Character.toUpperCase(newChar) : newChar);
                } else {
                    result.append(c); // Si el carácter no está en el alfabeto, lo agrega sin cambios
                }
            } else {
                result.append(c); // No cifrar caracteres no alfabéticos
            }
        }

        return result.toString();
    }

    /**
     * Desencripta una cadena usando un desplazamiento específico.
     *
     * @param encryptedText Texto cifrado
     * @param shift         Desplazamiento (para la desencriptación se usa negativo)
     * @return Texto descifrado
     */
    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, ALPHABET_SIZE - shift); // Usar el cifrado para desencriptar
    }

}


/**
 * Tanto el cifrado como la desencriptación son O(n), donde n es la longitud de la cadena,
 * ya que se recorren todos los caracteres del texto.=
 */
