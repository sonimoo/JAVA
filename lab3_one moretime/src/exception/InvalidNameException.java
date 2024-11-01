package exception;

public class InvalidNameException extends Exception {
    public InvalidNameException(String name) {
        super("Ошибка: Имя должно состоять из букв!");
    }
}
