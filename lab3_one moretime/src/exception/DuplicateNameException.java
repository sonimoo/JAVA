package exception;

public class DuplicateNameException extends Exception {
    public DuplicateNameException(String name) {
        super("Ошибка: Имя '" + name + "' уже существует.");
    }
}
