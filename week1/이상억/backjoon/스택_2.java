package week1.이상억.backjoon;

/**
 * PackageName : week1.이상억.backjoon
 * FileName    : 스택_2
 * Author      : sangeok
 * Date        : 2025. 5. 1.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 1.     sangeok               Initial creation
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> stack = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int option = sc.nextInt();

            if (option == 1) {
                int x = sc.nextInt();
                stack.add(x);}

            else if (option == 2) {
                if (stack.isEmpty()) {sb.append(-1).append('\n');}
                else {sb.append(stack.remove(stack.size() - 1)).append('\n');}
            }

            else if (option == 3) {sb.append(stack.size()).append('\n');}

            else if (option == 4) {sb.append(stack.isEmpty() ? 1 : 0).append('\n');}

            else if (option == 5) {
                if (stack.isEmpty()) {sb.append(-1).append('\n');}
                else {sb.append(stack.get(stack.size() - 1)).append('\n');}
            }
        }
        System.out.print(sb);
    }
}
