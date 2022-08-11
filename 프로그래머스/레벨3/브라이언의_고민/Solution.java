package 프로그래머스.레벨3.브라이언의_고민;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Character.isLowerCase;

public class Solution {
    public String solution(String sentence) {
        char type1, type2;
        ArrayList<String> answer = new ArrayList<>();
        HashSet<Character> used = new HashSet<>();

        for(int i=0; i<sentence.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char cur = sentence.charAt(i);
            if(isLowerCase(cur)) {
                if(used.contains(cur))
                    return "invalid";
                type2 = cur;
                used.add(cur);
                if(i>=sentence.length()-2)
                    return "invalid";

                char checkChar = sentence.charAt(i+2);
                if(checkChar==type2 || !isLowerCase(checkChar)) {       // aHELLOa
                    while(true) {
                        if(i==sentence.length()-1 || sentence.charAt(i)==type2)
                            break;
                        else
                            i++;

                        sb.append(sentence.charAt(i));
                    }
                } else {        // aHbEbLbLbOa
                    type1 = checkChar;
                    used.add(type1);
                    while(true) {
                        if(i>=sentence.length()-2)
                            break;

                        char nextBig = sentence.charAt(++i);
                        char nextSmall = sentence.charAt(++i);

                        if(isLowerCase(nextBig))
                            return "invalid";

                        sb.append(nextBig);
                        if(nextSmall==type2)
                            break;
                        else if(nextSmall!=type1)
                            return "invalid";
                    }
                }
            } else {
                sb.append(sentence.charAt(i));
                if(i==sentence.length()-1 || !isLowerCase(sentence.charAt(i+1))) {      // HELLO
                    while(true) {
                        char nextBig = sentence.charAt(i+1);
                        if(isLowerCase(nextBig))
                            break;

                        sb.append(nextBig);
                        i++;
                    }
                } else {        // HaEaLaLaO
                    type1 = sentence.charAt(i+1);
                    used.add(type1);
                    while(true) {
                        if(i>=sentence.length()-2)
                            break;

                        char nextSmall = sentence.charAt(i+1);
                        if(nextSmall!=type1)
                            break;

                        char nextBig = sentence.charAt(i+2);
                        if(isLowerCase(nextBig))
                            return "invalid";

                        sb.append(nextBig);
                        i += 2;
                    }
                }
            }

            answer.add(sb.toString());
        }

        String ret = "";
        for(String elem: answer)
            ret += elem + " ";

        return ret.substring(0, ret.length()-1);
    }
}