package utils;

import java.util.Scanner;

public class ValidationNumber {
    Scanner scanner = new Scanner(System.in);

    public int validateNumber(String line){
        while (!scanner.hasNext("[0-9]*$")){
            System.out.println("Допускается ввод только цифр, повторите попытку");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
