import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 길이
        int M = Integer.parseInt(br.readLine()); // 개수

        int[] pos = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = N;



        while(low < high){
            int mid = (low + high) / 2;

            if(check(mid,pos,N)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

    static boolean check(int H, int[] pos, int N){
        int cover = 0;

        for(int x : pos){

            if ( cover < x - H ) return false;

            cover = x + H;

            // 끝까지 밝힘
            if( cover >= N ) return true;
        }

        return cover >= N;
    }

}