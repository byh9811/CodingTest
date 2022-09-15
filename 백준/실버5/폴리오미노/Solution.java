package 백준.실버5.폴리오미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for(char c: input.toCharArray()) {
            if(c=='X') {
                cnt++;
                continue;
            }

            while(cnt!=0) {
                if(cnt>=4) {
                    sb.append("AAAA");
                    cnt -= 4;
                } else if(cnt>=2) {
                    sb.append("BB");
                    cnt -= 2;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
            sb.append('.');
        }

        while(cnt!=0) {
            if(cnt>=4) {
                sb.append("AAAA");
                cnt -= 4;
            } else if(cnt>=2) {
                sb.append("BB");
                cnt -= 2;
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb);
    }
}