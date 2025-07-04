package week3.강성욱.baekjoon;

//시간복잡도가 그냥 반복문 돌려도될듯?
//제일 오래 걸리는게, N = 250,000, X = 1 일때인데, 이때도 250,000 만 계산하면 되니..?
//처음 0, 1, ... X-1 까지 계산하고 슬라이딩
// 즉, now = list[0] + list[1] 일때
// 다음은, now - list[0] + list[2] 임
// 이걸 쭉 반복해서 이어가면 될듯. 가면서 조건확인

import java.util.Scanner;

public class 블로그 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += list[i];
        }

        int max = sum;
        int count = 1;

        for (int i = X; i < N; i++) {
            sum = sum - list[i - X] + list[i];

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}

