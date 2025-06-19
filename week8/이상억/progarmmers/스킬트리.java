/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 실패율
 * Author      : sangeok
 * Date        : 2025. 6. 19.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 19.     sangeok               Initial creation
 */

// 
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String tree : skill_trees){

            Stack<Character> stack = new Stack<>();

            for(int i = skill.length()-1 ; i >= 0; i--){
                stack.push(skill.charAt(i));
            }

            boolean isvalid = true;

            for(char c : tree.toCharArray()){
                if(!stack.contains(c)) continue;
                if( !stack.isEmpty() && c == stack.peek() ){
                    stack.pop();
                }
                else {
                    isvalid = false;
                    break;
                }
            }
            if(isvalid) answer++;

        }
        return answer;
    }
}