package week3.이상억.backjoon;
/**
 * PackageName :  week3.이상억.backjoon
 * FileName    : 블랙잭
 * Author      : sangeok
 * Date        : 2025. 5. 14.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 14.     sangeok               Initial creation
 */


// 문제 요구사항 : 카드 개수 -> N , 넘지 않아야 하며 가장 가까이 만들어야 하는 숫자 -> M

// 접근방법 : (1) 그냥 삼중 반복문 때려서 하면 될 거 같은데

// 회고 : 근데 삼중 반복문은 뭔가 좀 그렇다.. 효율적인 방법을 추가로 생각해야 할 것 같다.

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cardnumber = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cardnumber[i] = Integer.parseInt(st.nextToken());
        }

        int maxsum = 0;
        for(int i = 0 ; i < N - 2; i++){
            for(int j = i+1; j < N - 1; j++){
                for(int k = j+1; k < N; k++){
                    int sum = cardnumber[i] + cardnumber[j] + cardnumber[k];
                    if(( sum <= M ) && ( sum > maxsum )){
                        maxsum = sum;
                    }
                }
            }
        }

        System.out.println(maxsum);
    }
}