import java.io.*;
import java.util.*;


public class Main{

   static int[] parent;

   static int find(int x){
       if(parent[x] == x) return x;
       return parent[x] = find(parent[x]);
   }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        for(int i = 1; i <= N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int connected  = Integer.parseInt(st.nextToken());
                if(connected == 1){
                    union(i,j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first_city = Integer.parseInt(st.nextToken());
        int root = find(first_city);

        while(st.hasMoreTokens()){
            int city = Integer.parseInt(st.nextToken());
            if(find(city) != root){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
