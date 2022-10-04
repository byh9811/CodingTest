package 백준.실버5.DNA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] convert = {'A', 'C', 'G', 'T'};
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] dna = new String[N];
        StringBuilder sb = new StringBuilder();
        int hd = 0;

        for(int i=0; i<N; i++)
            dna[i] = br.readLine();
        Arrays.sort(dna);

        for(int i=0; i<M; i++) {
            int[] acgt = new int[4];

            for(int j=0; j<N; j++) {
                switch (dna[j].charAt(i)) {
                    case 'A': acgt[0]++; break;
                    case 'C': acgt[1]++; break;
                    case 'G': acgt[2]++; break;
                    default: acgt[3]++;
                }
            }

            int max = 0;
            int maxIdx = 0;
            for(int j=0; j<4; j++) {
                if(acgt[j]>max) {
                    max = acgt[j];
                    maxIdx = j;
                }
            }

            sb.append(convert[maxIdx]);
            hd += N - max;
        }

        System.out.println(sb + "\n" + hd);
    }
}