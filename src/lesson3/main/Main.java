package lesson3.main;

import lesson3.rainbow.Rainbow;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input number from 1 to 70:");

        int number = sc.nextInt();
        // Здесь просится обработка исключений но мы это еще не проходили

        if (number >= 1 & number <= 70) {
            Rainbow rainbow = new Rainbow();
            rainbow.printColor(number);
        } else {
            System.out.println(Rainbow.ERROR);
        }
    }
}
