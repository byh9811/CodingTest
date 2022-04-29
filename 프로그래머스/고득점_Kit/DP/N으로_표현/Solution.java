package 프로그래머스.고득점_Kit.DP.N으로_표현;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int N, int number) {
        Set[] sets = new Set[9];
        for(int i=0; i<9; i++)
            sets[i] = new HashSet<>();
        sets[1].add(N);

        for(int i=2; i<9; i++) {
            for(int j=1; j<i; j++) {
                Set<Integer> prefixes = sets[j];
                Set<Integer> postfixes = sets[i-j];

                for(int prefix: prefixes) {
                    for(int postfix: postfixes) {
                        sets[i].add(prefix + postfix);
                        sets[i].add(prefix - postfix);
                        sets[i].add(prefix * postfix);

                        if(prefix!=0 && postfix!=0) {
                            sets[i].add(prefix / postfix);
                        }
                    }
                }
            }
            sets[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for(int i=0; i<sets.length; i++) {
            if(sets[i].contains(number))
                return i;
        }

        return -1;
    }
}