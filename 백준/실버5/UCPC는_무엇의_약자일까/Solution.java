package 백준.실버5.UCPC는_무엇의_약자일까;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] target = {'U', 'C', 'P', 'C', '.'};
        String input = br.readLine();
        int idx = 0;
        for(char c: input.toCharArray()) {
            if(c==target[idx])
                idx++;
        }

        System.out.print(idx==4 ? "I love UCPC" : "I hate UCPC");
    }
}