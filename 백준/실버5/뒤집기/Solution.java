package 백준.실버5.뒤집기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] cnt = new int[2];
        char prev = '.';
        for(char c: input.toCharArray()) {
            if(prev==c)
                continue;

            cnt[c=='0' ? 0 : 1]++;
            prev = c;
        }
        System.out.println(Math.min(cnt[0], cnt[1]));
    }
}