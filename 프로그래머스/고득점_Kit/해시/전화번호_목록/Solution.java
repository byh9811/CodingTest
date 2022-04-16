package 프로그래머스.고득점_Kit.해시.전화번호_목록;

import java.util.HashSet;

public class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hashSet = new HashSet<>();

        for(String elem: phone_book)
            hashSet.add(elem);

        for(String elem: phone_book) {
            for(int i=0; i<elem.length(); i++) {
                if(hashSet.contains(elem.substring(0, i)))
                    return false;
            }
        }
        return true;
    }
}