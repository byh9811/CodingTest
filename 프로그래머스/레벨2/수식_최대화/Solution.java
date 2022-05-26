package 프로그래머스.레벨2.수식_최대화;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    long answer = 0;
    List<Long> operands;
    List<String> operators;

    public long solution(String expression) {
        String[] operatorArr = {"+", "-", "*"};
        boolean[] visited = new boolean[3];
        operands = new ArrayList<>();
        operators = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(expression, "+-*");
        int index = 0;
        while(st.hasMoreTokens()) {
            String number = st.nextToken();
            operands.add(Long.parseLong(number));
            index += number.length()+1;
            if(index!=expression.length()+1)
                operators.add(expression.substring(index-1, index));
        }

        permutation(0, operatorArr, new String[3], visited);
        return answer;
    }

    private void permutation(int index, String[] input, String[] output, boolean[] visited) {
        if(index==3) {
            calculate(output);
            return;
        }

        for(int i=0; i<input.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[index] = input[i];
                permutation(index+1, input, output, visited);
                visited[i] = false;
            }
        }
    }

    private void calculate(String[] order) {
        List<Long> operandCopy = new ArrayList<>(operands);
        List<String> operatorCopy = new ArrayList<>(operators);

        for(int i=0; i<order.length; i++) {
            for(int j=0; j<operatorCopy.size(); j++) {
                String operator = operatorCopy.get(j);
                if(operator.equals(order[i])) {
                    long result = cal(operandCopy.get(j), operandCopy.get(j+1), operator);
                    operandCopy.remove(j);
                    operandCopy.remove(j);
                    operandCopy.add(j, result);
                    operatorCopy.remove(j);
                    j--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(operandCopy.get(0)));
    }

    private long cal(long a, long b, String op) {
        switch (op) {
            case "+": return a+b;
            case "-": return a-b;
            default: return a*b;
        }
    }
}