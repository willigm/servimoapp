package ni.com.servimo.ServimoSa.util;

public class StringUtils {
    /**
     * Metodo que agrega el caracter % al inicio y al final de un String
     * Ej. value = pepito -> addLikeNotation(value) -> %pepito%
     * @param value Valor al que se agregaran los signos
     * @return Retorna el String original con los signos al inicio y al final
     */
    public static String addLikeNotation(String value){
        StringBuilder builder = new StringBuilder(value);
        builder.insert(0,'%');
        builder.append('%');
        return builder.toString();
    }
}
