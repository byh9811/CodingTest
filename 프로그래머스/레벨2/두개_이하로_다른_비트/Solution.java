package 프로그래머스.레벨2.두개_이하로_다른_비트;

public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            long number = numbers[i];

            if((number&1)==0)
                answer[i] = number+1;
            else {
                int idx = getLastZeroIndex(number);
                number += Math.pow(2, idx);
                number -= Math.pow(2, idx-1);
                answer[i] = number;
            }
        }

        return answer;
    }

    private int getLastZeroIndex(long number) {
        for(int i=0; i<65; i++) {
            int remain = (int)number % 2;
            number /= 2;
            if(remain==0)
                return i;
        }

        return -1;
    }
}