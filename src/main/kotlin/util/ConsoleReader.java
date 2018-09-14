package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    public static String readString() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter path to directory with music:");
                return br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Wrong input. Please try again.");
        }
    }
}
