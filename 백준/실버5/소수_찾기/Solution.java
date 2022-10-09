package 백준.실버5.소수_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int prime = 0;
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<num; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(number==1)
                continue;
            boolean isprime = true;

            for(int j=2; j<=Math.sqrt(number); j++) {
                if(number%j==0) {
                    isprime = false;
                    break;
                }
            }
            if(isprime)
                prime += 1;
        }

        System.out.print(prime);
        br.close();
    }
}