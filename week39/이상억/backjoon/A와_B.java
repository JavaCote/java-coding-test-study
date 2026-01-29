import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {
            char last = T.charAt(T.length() - 1);

            if (last == 'A') {
                // 맨 뒤 A 제거
                T.deleteCharAt(T.length() - 1);
            } else {
                // 맨 뒤 B 제거 후 뒤집기
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        if (T.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
