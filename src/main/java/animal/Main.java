package animal;

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
        String line = null;
        String name = null;
        int age;
        int weight;
        String color = null;
        ChooseActions chooseActions;
        ChooseTypeAnimals chooseTypeAnimals;
        ValidationNumber  validationNumber = new ValidationNumber();
        ValidationLine validationLine = new ValidationLine();



        while (true) {
            System.out.println("Введите команду add/list/exit");
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine().toUpperCase().trim();
            try {
                chooseActions = ChooseActions.valueOf(line);
            } catch (Exception exception) {
                System.out.println("Такой команды нет, повторите попытку еще раз \n" + exception.fillInStackTrace());
                continue;
            }
            switch (chooseActions) {
                case ADD:
                    System.out.println("Введите название животного");
                    String typeAnimal = scanner.nextLine().toUpperCase().trim();

                    if (!typeAnimal.equals("CAT") && !typeAnimal.equals("DOG") && !typeAnimal.equals("DUCK")) {

                        System.out.println("Такого животного нет, повторите попытку еще раз");
                        break;

                    } else {
                        System.out.println("Введите имя");
                        name = validationLine.validateLine(line);

                        System.out.println("Введите возраст");
                        age =validationNumber.validateNumber(line);

                        System.out.println("Введите вес");
                        weight = validationNumber.validateNumber(line);

                        System.out.println("Введите цвет");
                        color = validationLine.validateLine(line);

                        Animal animal = new FabrikaForAnimals(name,age,weight,color).createAnimal(ChooseTypeAnimals.valueOf(typeAnimal) );
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