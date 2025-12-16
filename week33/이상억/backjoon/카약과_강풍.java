import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] broken = new int[S];
        int[] extra = new int[R];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++){
            broken[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < R; i++){
            extra[i] = Integer.parseInt(st.nextToken());
        }


    }
}
