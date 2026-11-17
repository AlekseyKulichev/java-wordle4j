package ru.yandex.practicum;

public class InvalidDictionaryException extends IllegalArgumentException {
    public InvalidDictionaryException(String message) {
        super(message);
    }
}
