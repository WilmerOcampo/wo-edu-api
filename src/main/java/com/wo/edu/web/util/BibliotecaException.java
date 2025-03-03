package com.wo.edu.web.util;

public class BibliotecaException extends RuntimeException {
    public static final String EJEMPLAR_NO_DISPONIBLE = "Ejemplar no disponible";
    public static final String NO_HAY_EJEMPLARES_DISPONIBLES = "No hay ejemplares disponibles";
    public static final String USUARIO_NO_EXISTENTE = "Usuario no existente";
    public static final String EJEMPLAR_NO_EXISTENTE = "Ejemplar no existente";
    public static final String USUARIO_NO_ACTIVO = "Usuario no activo";
    public static final String USUARIO_NO_TIENE_EJEMPLAR = "Usuario no tiene ejemplar";

    public BibliotecaException() {
        super();
    }

    public BibliotecaException(String message) {
        super(message);
    }

    public BibliotecaException(String message, Throwable cause) {
        super(message, cause);
    }
}
