import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] pos = new int[N];

        for(int i = 0; i < N; i++){
            pos[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(pos);

        int low = 1;
        int high = pos[N - 1] - pos[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (check(mid, pos, C)) {
                low = mid + 1; //  더 큰 거리 시도
            } else {
                high = mid; //  거리 줄여야 함
            }
        }

        System.out.println(low - 1);

    }

    static boolean check(int D, int[] pos, int C){
        int count = 1;
        int last = pos[0];

        for(int i = 1; i < pos.length; i++){
            if(pos[i] - last >= D){
                count ++;
                last = pos[i];
            }
            if ( count >= C) return true;

        }
        return false;
    }

}