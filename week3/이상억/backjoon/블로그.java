package week3.이상억.backjoon;
/**
 * PackageName :  week3.이상억.backjoon
 * FileName    : 블로그
 * Author      : sangeok
 * Date        : 2025. 5. 14.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 14.     sangeok               Initial creation
 */

// 문제 요구사항 :	첫째 줄 시작하고 지난 일수 N , 알고 싶은 일수 X
//                  두번째 줄 1일차부터 N일차까지 하루 방문자 수 공백 구분

//                  최대 방문자 수 0 => SAD 출력
//                  최대 방문자 수 0 아니면 =>  최대 일수가 몇 번인 지 두번째 줄 출력

// 회고 :             sum = sum - visits[i-X] + visits[i];
//      이 로직을 생각하는데 뇌사가 와서 꽤 많은 고민을 했던 것 같다.
//      그리고 이 문제를 푸는데 있어서 뭔가 생각이 잘 정리 되지 않아.
//      보통 접근방식에 대한 생각을 하고 코딩을 하는데 이 문제는 그러한 부분이 잘 되지 않아 오래 걸렸던 것 같다.
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visits = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 1;

        for(int i = 0; i < X; i++){
            sum += visits[i];
        }
        int maxvisit = sum;

        for(int i = X; i < N; i++){
            sum = sum - visits[i-X] + visits[i]; // [i-X] + [i]는 => 가장 왼쪽 값 지우고 오른쪽 값 더하기, 즉 한칸 옆으로 이동
            if(sum > maxvisit) {
                maxvisit = sum;
                count = 1;
            } else if(sum == maxvisit) count ++;
        }

        if (maxvisit == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxvisit);
            System.out.println(count);
        }
    }
}