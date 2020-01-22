package br.com.hbsis.distance.utils;

import br.com.hbsis.distance.payloads.AddressTooLong;

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

    public static void validateStringSize(String string, String message) throws AddressTooLong {
        if(string.length() > 200) {
            throw new AddressTooLong(message);
        }
    }
}
