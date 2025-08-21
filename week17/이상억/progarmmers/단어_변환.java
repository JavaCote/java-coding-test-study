/**
 * PackageName : week17.이상억.progarmmers;
 * FileName    : 단어_변환
 * Author      : sangeok
 * Date        : 2025. 08. 21.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 21.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new String[]{begin,"0"});

        while(!queue.isEmpty()){
            String[] current = queue.poll();
            String word = current[0];
            int count = Integer.parseInt(current[1]);

            if(word.equals(target)){
                return count;
            }

            for(int i = 0; i < words.length; i++){
                if(!visited[i] && is_changed(word,words[i])){
                    visited[i] = true;
                    queue.add(new String[]{words[i],String.valueOf(count + 1)});
                }
            }
        }
        return 0;
    }


    public boolean is_changed(String a,String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i ++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}