import java.util.*;

class Solution {
    public long solution(String expression) {

        List<Long> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0); // 숫자 버퍼 초기화
                operators.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString())); // 마지막 숫자 추가

        // 연산자 우선순위 경우의 수
        String[][] orders = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "+", "-"},
                {"*", "-", "+"}
        };

        long answer = 0;
        for (String[] order : orders) {
            answer = Math.max(answer,
                    Math.abs(calc(new ArrayList<>(numbers), new ArrayList<>(operators), order)));
        }
        return answer;
    }

    // 특정 우선순위에 따라 계산
    private long calc(List<Long> nums, List<String> ops, String[] order) {
        for (String op : order) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i).equals(op)) {
                    long a = nums.remove(i);
                    long b = nums.remove(i);
                    nums.add(i, operate(a, b, op));
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }
        return nums.get(0);
    }

    private long operate(long a, long b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        return a * b;
    }
}
