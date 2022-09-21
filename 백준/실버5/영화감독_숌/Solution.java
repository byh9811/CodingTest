package 백준.실버5.영화감독_숌;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int cur = 665;

        while(true) {
            if(!Integer.toString(++cur).contains("666"))
                continue;

            cnt++;
            if(cnt==N) {
                System.out.println(cur);
                break;
            }
        }
    }
}