package 백준.실버5.K_세준수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i<N+1; i++) {
            if(isPrime[i]) {
                for(int j=i+i; j<N+1; j+=i)
                    isPrime[j] = false;
            }
        }

        for(int i=K+1; i<N+1; i++) {
            if(isPrime[i]) {
                for(int j=i; j<N+1; j+=i)
                    set.add(j);
            }
        }

        System.out.println(N-set.size());
    }
}