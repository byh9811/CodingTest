package 백준.실버5.크로아티아_알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        char prev = '.', pprev = '.';
        String input = br.readLine();

        for(char cur: input.toCharArray()) {
            if(cur=='=') {
                if(pprev=='d' && prev=='z')
                    answer -= 2;
                else
                    answer--;
            } else if(cur=='-') {
                answer--;
            } else if(cur=='j' && (prev=='l' || prev=='n')) {
                answer--;
            }

            pprev = prev;
            prev = cur;
            answer++;
        }

        System.out.println(answer);
    }
}