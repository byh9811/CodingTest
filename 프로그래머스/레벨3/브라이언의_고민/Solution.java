package 프로그래머스.레벨3.브라이언의_고민;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Character.isLowerCase;

public class Solution {
    ArrayList<String> answer = new ArrayList<>();
    HashSet<Character> used = new HashSet<>();
    public String solution(String sentence) {
        try {
            int start = 0;

            for(int i=0; i<sentence.length(); i++) {
                char cur = sentence.charAt(i);

                if(cur==' ')
                    throw new Exception();

                if (isLowerCase(cur)) {
                    if (used.contains(cur))
                        throw new Exception();

                    int EOW;
                    used.add(cur);

                    if (!isLowerCase(sentence.charAt(i + 2))) {
                        if (start < i)
                            answer.add(sentence.substring(start, i));
                        EOW = parseRule2(i, cur, sentence);
                    } else if (sentence.charAt(i+2)!=cur) { // start<=i-1 && (i > sentence.length() - 2 || sentence.charAt(i + 2) == cur || sentence.charAt(i + 2) == )
                        if (start < i)
                            answer.add(sentence.substring(start, i));
                        EOW = parseBothRules(i, cur, sentence.charAt(i + 2), sentence);
                    } else {
                        if (start != i - 1)
                            answer.add(sentence.substring(start, i - 1));
                        EOW = parseRule1(i - 1, cur, sentence);
                    }

                    i = EOW;
                    start = EOW + 1;
                    System.out.println(EOW);
                }
            }

            if (start != sentence.length())
                answer.add(sentence.substring(start));
        } catch (Exception e) {
            return "invalid";
        }

        String ret = "";
        for(String elem: answer)
            ret += elem + " ";

        return ret.substring(0, ret.length()-1);
    }

    private int parseRule1(int idx, char sp, String sentence) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(sentence.charAt(idx++));

        while(true) {
            if(idx>=sentence.length()-1 || sentence.charAt(idx)!=sp)
                break;

            idx++;
            if(isLowerCase(sentence.charAt(idx)))
                throw new Exception();

            sb.append(sentence.charAt(idx++));
        }

        answer.add(sb.toString());
        return idx-1;
    }

    private int parseRule2(int idx, char sp, String sentence) throws Exception {
        StringBuilder sb = new StringBuilder();
        idx++;

        while(true) {
            if(sentence.charAt(idx)==sp)
                break;

            if(isLowerCase(sentence.charAt(idx)))
                throw new Exception();

            sb.append(sentence.charAt(idx++));
        }

        answer.add(sb.toString());
        return idx;
    }

    private int parseBothRules(int idx, char sp2, char sp1, String sentence) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (used.contains(sp1))
            throw new Exception();
        used.add(sp1);
        idx++;

        while(true) {
            if(isLowerCase(sentence.charAt(idx)))
                throw new Exception();

            sb.append(sentence.charAt(idx++));

            if(sentence.charAt(idx)==sp2)
                break;
            else if(sentence.charAt(idx++)!=sp1)
                throw new Exception();
        }

        answer.add(sb.toString());
        return idx;
    }

}