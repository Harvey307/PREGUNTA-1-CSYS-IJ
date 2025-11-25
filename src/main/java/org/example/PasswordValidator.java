package org.example;

public class PasswordValidator {

    public static boolean isValid(String password) {

        // 1. Validar si es nulo o vacío primero (Escenario 1)
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        // 2. Validar longitud (min 8, max 64)
        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        // 3. Validar que no tenga espacios en blanco
        if (password.contains(" ")) {
            return false;
        }

        // 4. Verificar caracteres requeridos usando "banderas"
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        // Lista de caracteres especiales permitidos según el examen
        String especiales = "!@#$%^&*()_-+={}[]|\\:;\"'<>,.?/";

        // Recorremos la contraseña carácter por carácter
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (especiales.indexOf(c) >= 0) {
                // Si el carácter actual existe en la cadena de especiales
                tieneEspecial = true;
            }
        }
        // Retornamos true solo si cumple TODAS las banderas
        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneEspecial;
    }

}
