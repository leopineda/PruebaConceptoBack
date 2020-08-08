package fi.util.validacion;

import org.springframework.util.Assert;

public class ValidadorCadena {
    /**
     * Constructor
     */
    public ValidadorCadena() {
        super();
    }

    /**
     * Metodo estatico que permite validar una cadena que no sea nula y/o una cadena vacia
     * @param string Cadena a validar
     */
    public static void notNullNorEmpty(String string) {
        Assert.notNull(string, "La cadena no puede ser nula");
        Assert.hasText(string, "La cadena no puede ser vacia");
    }
}
