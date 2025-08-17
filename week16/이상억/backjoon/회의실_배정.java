/**
 * PackageName : week16.이상억.backjoon;
 * FileName    : 회의실_배정
 * Author      : sangeok
 * Date        : 2025. 08. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 12.     sangeok               Initial creation
 */


import java.util.*;
import java.io.*;

public class Main {
    static class Meeting {
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine().trim());
        Meeting[] arr = new Meeting[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Meeting(start, end);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.end != b.end) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });

        int count = 0;
        int last_end = 0;
        for(Meeting m : arr) {
            if(m.start >= last_end){
                count++;
                last_end = m.end;
            }
        }

        System.out.println(count);
    }
}
