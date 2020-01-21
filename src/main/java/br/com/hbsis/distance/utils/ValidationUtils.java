package br.com.hbsis.distance.utils;

public class ValidationUtils {

    public static void validateIfNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validadeIfEmpty(String string, String message) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
