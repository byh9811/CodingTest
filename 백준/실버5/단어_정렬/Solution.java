package 백준.실버5.단어_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Word implements Comparable<Word> {
    int length;
    String word;

    public Word(int length, String word) {
        this.length = length;
        this.word = word;
    }

    public int compareTo(Word o) {
        if(length!=o.length)
            return length-o.length;
        else
            return word.compareTo(o.word);
    }

    @Override
    public boolean equals(Object o) {
        Word word = (Word)o;
        return this.word.equals(word.word);
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Word> wordList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            Word word = new Word(input.length(), input);

            if(!wordList.contains(word))
                wordList.add(word);
        }

        wordList.sort(null);
        for(Word word: wordList)
            System.out.println(word.word);
    }
}