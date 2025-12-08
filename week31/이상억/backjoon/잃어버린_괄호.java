import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();

        List<Integer> numbers = new ArrayList<>();
        List<Character> op = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < expression.length(); i++){
            char c = expression.charAt(i);

            if(c == '+' || c == '-'){
                numbers.add(Integer.parseInt(sb.toString()));
                op.add(c);
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Integer.parseInt(sb.toString()));


        int result = numbers.get(0);
        boolean minusmode = false;

        int idx = 1;

        for(int i = 0; i < op.size(); i++){
            char oper = op.get(i);

            if(oper == '-'){
                minusmode = true;
                result -= numbers.get(idx++);
            } else {
                if(minusmode){
                    result -= numbers.get(idx++);
                } else{
                    result += numbers.get(idx++);
                }
            }
        }

        System.out.println(result);
    }
}
