package 프로그래머스.고득점_Kit.정렬.가장_큰_수;

import java.util.*;

class Number implements Comparable<Number> {
    String value;

    public Number(String value) {
        this.value = value;
    }

    public int compareTo(Number n) {
        return Integer.parseInt(value+n.value) - Integer.parseInt(n.value+value);
    }
}

public class Solution {
    public String solution(int[] numbers) {
        Number[] numStr = new Number[numbers.length];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< numbers.length; i++) {
            numStr[i] = new Number(Integer.toString(numbers[i]));
        }

        Arrays.sort(numStr, Collections.reverseOrder());
        if(numStr[0].value.equals("0"))
            return "0";

        for(Number num: numStr) {
            sb.append(num.value);
        }

        return sb.toString();
    }
}