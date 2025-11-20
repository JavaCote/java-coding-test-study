import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> plus_numbers = new ArrayList<>();
        List<Integer> minus_numbers = new ArrayList<>();

        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) plus_numbers.add(num);
            else if (num == 1) ones++;
            else if (num == 0) zeros++;
            else minus_numbers.add(num);
        }

        Collections.sort(plus_numbers, Collections.reverseOrder());
        Collections.sort(minus_numbers);

        long result = 0;

        for (int i = 0; i < plus_numbers.size(); ) {
            if (i + 1 < plus_numbers.size()) {
                int a = plus_numbers.get(i);
                int b = plus_numbers.get(i + 1);
                result += a * b;
                i += 2;
            } else {
                result += plus_numbers.get(i);
                i += 1;
            }
        }

        result += ones;

        for (int i = 0; i < minus_numbers.size(); ) {
            if (i + 1 < minus_numbers.size()) {
                int a = minus_numbers.get(i);
                int b = minus_numbers.get(i + 1);
                result += a * b;
                i += 2;
            } else {
                if (zeros > 0) {
                    zeros--;
                    i += 1;
                } else {
                    result += minus_numbers.get(i);
                    i += 1;
                }
            }
        }

        System.out.println(result);
    }
}
