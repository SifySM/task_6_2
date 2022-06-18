package edu.vsu.ru.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class ListUtils {

    public static List<String> readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }

    public static List<String []> splitString(List<String> list){
        List<String []> flat = new ArrayList<>();

        for(String i : list){
            String [] property = i.split(" ");
            flat.add(property);
        }
        return flat;
    }

    public static List<String []> readListFromFile(String fileName) throws FileNotFoundException {
        return splitString(readLinesFromFile(fileName));
    }

    public static List<String> strArrayToList(String[] arr) {
        List<String> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(i, arr[i]);
        }
        return list;
    }

    public static String[] strListToArr(List<String> list ){
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static String [][] strListToMatrix(List<String[]> list) {
        String[][] arr = new String[list.size()][5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static List<String[]> strMatrixToList(String[][] arr) {
        List<String[]> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(i, arr[i]);
        }
        return list;
    }

    public static String strListToStr(List<String> list){
        String str = "";

        for (String i : list){
            str = str + i + " ";
        }

        return str;
    }
    public static List<String> intListToStringList(List<Integer> pairs) {
        List<String> strListPairs = new ArrayList<>();
        for (int minFromPair : pairs) {
            strListPairs.add(minFromPair + " ");
        }
        return strListPairs;
    }
}
