package 프로그래머스.레벨2.일24_나라의_숫자;

import java.util.Stack;

public class Solution {
    public String solution(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n>0) {
            int remain = n%3;
            switch (remain) {
                case 1: stack.add(1); break;
                case 2: stack.add(2); break;
                default: stack.add(4);
            }

            n /= 3;
            if(remain==0)
                n--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }
}