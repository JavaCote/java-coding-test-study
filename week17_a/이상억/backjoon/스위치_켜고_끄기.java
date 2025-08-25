import java.util.*;
import java.io.*;


public class Main{

    static int[] switches;

    static void toggle(int idx){
        switches[idx] = (switches[idx] == 0 ) ? 1 : 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        switches = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <=n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int student_count = Integer.parseInt(br.readLine());

        for(int s = 0; s < student_count; s ++ ){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1){
                for(int i = num; i <= n; i +=num){
                    toggle(i);
                }
            }
            else{
                toggle(num);
                int left = num - 1;
                int right = num + 1;
                while(left >= 1 && right <=n && switches[left] == switches[right]){
                    toggle(left);
                    toggle(right);
                    left--;
                    right++;
                }
            }
        }

        for(int i = 1 ; i <= n; i ++){
            sb.append(switches[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }

        System.out.print(sb);

    }
}
