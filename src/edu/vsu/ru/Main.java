package edu.vsu.ru;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] srcArray = ArrayHandler.readSrcArrayFromConsole();
        int sum = readSum();
        ArrayHandler.writeOnConsole(ArrayHandler.findPairs(srcArray, sum), sum);
    }

    private static int readSum() {
        System.out.print("Введите сумму в парах: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
