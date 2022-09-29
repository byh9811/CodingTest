package 백준.실버5.수들의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int cnt = 1;
        long sum = 0;

        while(sum+cnt<=S)
            sum += cnt++;

        System.out.println(cnt-1);
    }
}