package 백준.골드5.리모컨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> broken = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        if(M!=0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++)
                broken.add(Integer.parseInt(st.nextToken()));
        }

        int answer = Math.abs(N-100);
        for(int i=0; i<1000000; i++) {
            boolean able = true;
            int push = 0;
            int num = i;
            while(true) {
                if(broken.contains(num%10)) {
                    able = false;
                    break;
                }
                num /= 10;
                push++;
                if(num==0)
                    break;
            }

            if(able)
                answer = Math.min(answer, Math.abs(N-i)+push);
        }

        System.out.println(answer);
    }
}