package week2.김나은.bakejoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int movieName = 666;
        int count = 1;

        while(N > count){
            movieName++;

            if(String.valueOf(movieName).contains("666")){
                count++;
            }
        }

        bw.write(movieName+"");
        bw.flush();
        bw.close();

    }
}