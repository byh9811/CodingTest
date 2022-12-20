package 프로그래머스.레벨1.옹알이;

public class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String word: babbling) {
            int idx = 0;
            boolean speakable = true;
            char prev = '.';
            while(idx<word.length()) {
                if(word.charAt(idx)=='a' && prev!='a' && idx+2<word.length() && word.charAt(idx+1)=='y' && word.charAt(idx+2)=='a') {
                    prev = 'a';
                    idx += 3;
                } else if(word.charAt(idx)=='m' && prev!='m' && idx+1<word.length() && word.charAt(idx+1)=='a') {
                    prev = 'm';
                    idx += 2;
                } else if(word.charAt(idx)=='w' && prev!='w' && idx+2<word.length() && word.charAt(idx+1)=='o' && word.charAt(idx+2)=='o') {
                    prev = 'w';
                    idx += 3;
                } else if(word.charAt(idx)=='y' && prev!='y' && idx+1<word.length() && word.charAt(idx+1)=='e') {
                    prev = 'y';
                    idx += 2;
                } else {
                    speakable = false;
                }
                if(!speakable)
                    break;
            }

            if(speakable)
                answer++;
        }

        return answer;
    }
}