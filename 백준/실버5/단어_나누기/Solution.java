package 백준.실버5.단어_나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<>();
        String input = br.readLine();

        for(int i=1; i<input.length()-1; i++) {
            for(int j=i+1; j<input.length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(new StringBuffer(input.substring(0, i)).reverse());
                sb.append(new StringBuffer(input.substring(i, j)).reverse());
                sb.append(new StringBuffer(input.substring(j)).reverse());
                words.add(sb.toString());
            }
        }

        words.sort(null);
        System.out.println(words.get(0));
    }
}