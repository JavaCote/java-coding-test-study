//

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        Set<String> unheard = new HashSet<>();
        for(int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < M; i++){
            String name = br.readLine();
            if(unheard.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(String name : result){
            System.out.println(name);
        }
    }
}