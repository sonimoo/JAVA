import java.util.ArrayList;
import java.util.Scanner;
import exception.InvalidNameException;
import exception.DuplicateNameException;

public class NameHandler {

    public ArrayList<String> inputNames(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        while (true) {
            System.out.print("Введите имя (или введите 'exit' для выхода): ");
            String inputName = scanner.nextLine();

            if ("exit".equalsIgnoreCase(inputName)) {
                System.out.println("Выход...");
                break;
            }

            try {
                if (!inputName.matches("^[А-яA-z]+(-[А-яA-z]+)?$")) {
                    throw new InvalidNameException(inputName);
                }
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                if (names.contains(inputName.toLowerCase())) {
                    throw new DuplicateNameException(inputName);
                } else {
                    names.add(inputName.toLowerCase());
                    System.out.println("успешно добавлено!");
                }
            } catch (DuplicateNameException e) {
                System.out.println(e.getMessage());
            }

            printNames(names);
        }
        return names;
    }

    public void printNames(ArrayList<String> names) {

        System.out.println("Текущий список имен: " + names);
    }

    public static void main(String[] args) {
        NameHandler nameHandler = new NameHandler();
        nameHandler.inputNames();
    }
}
