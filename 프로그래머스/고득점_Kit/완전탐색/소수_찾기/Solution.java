package 프로그래머스.고득점_Kit.완전탐색.소수_찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        permutation("", numbers);

        for(int elem: set) {
            if(isPrime(elem))
            answer += 1;
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if(num==0 || num==1)
            return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0)
                return false;
        }

        return true;
    }

    private void permutation(String prefix, String numbers) {
        if(!prefix.equals(""))
            set.add(Integer.parseInt(prefix));

        for(int i=0; i<numbers.length(); i++)
            permutation(prefix+numbers.substring(i, i+1), numbers.substring(0, i)+numbers.substring(i+1));
    }
}