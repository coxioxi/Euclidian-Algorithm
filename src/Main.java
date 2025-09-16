import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        List<Integer> results = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        line = reader.readLine(); // array size
        int size = Integer.parseInt(line);
        int[] numbers = new int[size];
        int count = 0;

        line = reader.readLine();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < line.length()-1; ++i) {
            while(i <= line.length()-1 && line.charAt(i) != ' ') {
                buffer.append(line.charAt(i));
                ++i;
            }

            numbers[count] = Integer.parseInt(buffer.toString());
            buffer.delete(0, buffer.length());
            ++count;
        }

        for (int i = 0; i < numbers.length; i += 2) {

            int x = 0;
            int lastX = 1;

            int y = 1;
            int lastY = 0;

            int a = numbers[i];
            int b = numbers[i+1];
            int origMod = b;

            while (b != 0) {
                int quotient = a/b;
                int temp = b;
                b = a % b;
                a = temp;

                temp = x;
                x = lastX - quotient * x;
                lastX = temp;

                temp = y;
                y = lastY - quotient * y;
                lastY = temp;
            }

            if (a != 1) {
                results.add(null);
            } else {
                int inverse = (lastX % origMod + origMod) % origMod;
                results.add(inverse);
            }
        }

        System.out.println(results);

    }
}