import animal.Animal;
import data.ChooseActions;
import data.ChooseTypeAnimals;
import fabrika.FabrikaForAnimals;
import utils.ValidationLine;
import utils.ValidationNumber;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        ChooseActions chooseActions;
        ChooseTypeAnimals chooseTypeAnimals;
        ValidationNumber validationNumber = new ValidationNumber();
        ValidationLine validationLine = new ValidationLine();

        while (true) {
            ArrayList<String> actionForEnum = new ArrayList<>();
            for (ChooseActions chooseActions1 : ChooseActions.values()) {
                actionForEnum.add(chooseActions1.name().toUpperCase());
            }
            System.out.println("Введите введите команду: " + String.join("/", actionForEnum));                      // Вывод команд через Enum
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().toUpperCase().trim();
            try {
                chooseActions = ChooseActions.valueOf(line);
            } catch (Exception exception) {
                System.out.println("Такой команды нет, повторите попытку еще раз \n" + exception.fillInStackTrace());
                continue;
            }
            switch (chooseActions) {
                case ADD:
                    ArrayList<String> animalsForEnum = new ArrayList<>();
                    for (ChooseTypeAnimals chooseTypeAnimals1 : ChooseTypeAnimals.values()) {
                        animalsForEnum.add(chooseTypeAnimals1.name().toUpperCase());
                    }
                    System.out.println("Введите название животного: " + String.join("/", animalsForEnum));          // Вывод животных через Enum
                    String typeAnimal = scanner.nextLine().toUpperCase().trim();

                    if (!animalsForEnum.contains(typeAnimal)) {                                                             // Сравнение строки с элементами массива, полученных из Enum
                        System.out.println("Такого животного нет, повторите попытку еще раз");
                        break;
                    } else {
                        System.out.println("Введите имя");
                        String name = validationLine.validateLine(line);

                        System.out.println("Введите возраст");
                        int age = validationNumber.validateNumber(line);

                        System.out.println("Введите вес");
                        int weight = validationNumber.validateNumber(line);

                        System.out.println("Введите цвет");
                        String color = validationLine.validateLine(line);

                        Animal animal = new FabrikaForAnimals(name, age, weight, color).createAnimal(ChooseTypeAnimals.valueOf(typeAnimal));
                        animals.add(animal);
                        System.out.println(animal.say());
                        break;
                    }

                case LIST:
                    if (animals.size() == 0) {
                        System.out.println("На данный момент список пуст");
                        continue;
                    } else {
                        for (Animal an : animals)
                            System.out.println(an.toString());
                    }
                    break;

                case EXIT:
                    scanner.close();
                    System.out.println("Выход");
                    System.exit(0);
            }

        }

    }
}