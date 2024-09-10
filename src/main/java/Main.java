import animal.Animal;
import data.ChooseActions;
import data.ChooseTypeAnimals;
import fabrika.FabrikaForAnimals;
import utils.ValidationLine;
import utils.ValidationNumber;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<String> animals2 = new ArrayList<>();
        ChooseActions chooseActions;
        ChooseTypeAnimals chooseTypeAnimals;
        ValidationNumber validationNumber = new ValidationNumber();
        ValidationLine validationLine = new ValidationLine();

        while (true) {
            System.out.println("Введите команду add/list/exit");
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
                    int i = 0;

                    for(ChooseTypeAnimals chooseTypeAnimals1: ChooseTypeAnimals.values()) {
                       // myArray[i] = chooseTypeAnimals1.name().toLowerCase();
                        animals2.add(i,chooseTypeAnimals1.name().toLowerCase());
                        i++;
                    }
                  //  System.out.println("Введите название животного");
                    System.out.println("Введите название животного: " + String.join("/", animals2));
                    String typeAnimal = scanner.nextLine().toUpperCase().trim();

                    if (!typeAnimal.equals("CAT") && !typeAnimal.equals("DOG") && !typeAnimal.equals("DUCK")) {

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
//
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