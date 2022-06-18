package edu.vsu.ru;

import edu.vsu.ru.util.ArrayUtils;

import java.io.*;
import java.util.*;

public class ArrayHandler {

    public static List<Integer> findPairs(int[] arraySrc, int S) {
        List<Integer> differentPairs = new ArrayList<>();
        Map<Integer, Integer> pairs = new HashMap<>();

        for (int i : arraySrc) {
            int minFromPairs = i;
            if (minFromPairs*2 > S) minFromPairs = S - minFromPairs;
 
            if (pairs.containsKey(minFromPairs)) {

                Integer value = pairs.get(minFromPairs);
                if ((value != null) && (value == i)) {
                    differentPairs.add(minFromPairs);
                    pairs.put(minFromPairs, null);
                }

            } else pairs.put(minFromPairs, S-i);
        }

        return differentPairs;
    }

    public static int[] readSrcArrayFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return ArrayUtils.toIntArray(sb.toString());
        } finally {
            br.close();
        }
    }

    public static int[] readSrcArrayFromConsole(){
        return ArrayUtils.readIntArrayFromConsole();
    }

    public static void writeOnConsole(List<Integer> pairs, int S) {
        System.out.println("Полученные пары: ");
        for (int minFromPair : pairs) {
            System.out.println(minFromPair + " " + (S - minFromPair));
        }
    }

    public static void writeToFile(String file, List<Integer> pairs, int S) {
        List<String> strListPairs = convertPairsToStringList(pairs, S);
        try
        {
            OutputStream f = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for(int i = 0; i < strListPairs.size(); i++)
            {
                out.write(strListPairs.get(i));
                out.flush();
            }
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }

    private static List<String> convertPairsToStringList(List<Integer> pairs, int S) {
        List<String> strListPairs = new ArrayList<>();
        for (int minFromPair : pairs) {
            strListPairs.add(minFromPair + " " + (S - minFromPair));
        }
        return strListPairs;
    }
}
