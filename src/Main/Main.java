package Main;

import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static double price;
    static double finalprice;
    static double tax;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.println("Input product price: "); //Ввод значения;

        try {  //Использование исключения при вводе не числа;
            price = scanner.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        calculateTax();
        calculatePrice();
        showResult();

    }
    private static void calculateTax (){   //Метод подсчета процента скидки;
        if (price >= 0 && price <= 5000) {
            tax = price * 0.5;

        } else if (price > 5000 && price <= 10000) {
            tax = price * 0.10;

        } else if (price > 10000) {
            tax = price * 0.15;

        } else {
            System.out.println("The entered value is incorrect");
            return;
        }
    }
    private static void calculatePrice(){   //Метод подсчета сумы к оплате;
        finalprice = price - tax;
    }

    private static void showResult(){ //Метод вывода конечной информации о значениях;
        System.out.printf("Price: %.2f%n", price);
        System.out.printf("Tax quantity: %.2f%n", tax);
        System.out.printf("Final price: %.2f%n", finalprice);
    }
}
