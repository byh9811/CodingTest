package 백준.골드5.암호_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    int L, C;
    char[] letter;
    boolean[] visited;
    StringBuilder sb = new StringBuilder();
    HashSet<Character> vowels = new HashSet<>();
    HashSet<Character> consonants = new HashSet<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        letter = new char[C];
        visited = new boolean[C];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            letter[i] = st.nextToken().charAt(0);
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(char i='a'; i<='z'; i++) {
            if(!vowels.contains(i))
                consonants.add(i);
        }

        Arrays.sort(letter);
        permutation(0, 0);
        System.out.println(sb);
    }

    private void permutation(int cnt, int start) {
        if(cnt==L) {
            StringBuffer buffer = new StringBuffer();
            int v = 0;
            int c = 0;
            for(int i=0; i<C; i++) {
                if(visited[i]) {
                    if(vowels.contains(letter[i]))
                        v++;
                    else if(consonants.contains(letter[i]))
                        c++;
                    buffer.append(letter[i]);
                }
            }
            if(v>=1 && c>=2)
                sb.append(buffer).append('\n');
            return;
        } else if(start==C) {
            return;
        }

        for(int i=start; i<C; i++) {
            visited[i] = true;
            permutation(cnt+1, i+1);
            visited[i] = false;
        }
    }
}