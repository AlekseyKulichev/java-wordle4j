package ru.yandex.practicum;

public class InvalidGameStateException extends IllegalStateException {
    public InvalidGameStateException(String message) {
        super(message);
    }
}
