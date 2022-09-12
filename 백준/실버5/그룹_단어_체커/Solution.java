package 백준.실버5.그룹_단어_체커;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            boolean[] used = new boolean['Z'-'A'+1];
            char prev = '.';
            boolean isGroupWord = true;

            for(char c: word.toCharArray()) {
                if(c!=prev && used[c-'a']) {
                    isGroupWord = false;
                    break;
                }
                used[c-'a'] = true;
                prev = c;
            }

            if(isGroupWord)
                answer++;
        }

        System.out.println(answer);
    }
}