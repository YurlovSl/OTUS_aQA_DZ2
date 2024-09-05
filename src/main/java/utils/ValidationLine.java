package utils;

import java.util.Scanner;

public class ValidationLine {
    Scanner scanner = new Scanner(System.in);

    public String validateLine(String line){
        while (!scanner.hasNext("[а-яА-Я-a-zA-Z]*$")){
            System.out.println("Допускается ввод только символов, повторите попытку");
            scanner.next();
        }
        return scanner.next();
    }
}
