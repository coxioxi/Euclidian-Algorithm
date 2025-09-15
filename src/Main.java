import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        List<ArrayList<Integer>> nums = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int count = 0;

        line = reader.readLine();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ' ' || i == 0) {
                nums.add(new ArrayList<>());
                if (!number.isEmpty())
                    nums.get(count).add(Integer.parseInt(number.toString()));
                number.delete(0, number.length());
            }
            else
                number.append(line.charAt(i));
        }

        System.out.println(nums);

        for (int i = 0; i < nums.size(); i++) {

            int x = 0;
            int lastX = 1;

            int y = 1;
            int lastY = 0;

            int a = nums.get(i).get(0);
            int b = nums.get(i).get(1);

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

            results.add(lastX);
        }

        System.out.println(results);
    }
}