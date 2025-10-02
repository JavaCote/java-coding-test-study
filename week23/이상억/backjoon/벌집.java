// N이 주어졌을 때 최소 개수 방을 지나서 갈 때 몇개의 방을 지나는지 ?
// 끝방 7,19,37,61 ?
// 6 ( 1 + 2 + .. + n - 1 ) + 1? -> 3 n(n-1) + 1
//
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int layer = 1;
        int end = 1;    // 현재 층의 마지막 방 번호

        while (n > end) {
            layer++;
            end = 3*layer*(layer-1) + 1; // layer 기준으로 갱신
        }
        System.out.println(layer);
    }
}
