package 프로그래머스.레벨1.서울에서_김서방_찾기;

public class Solution {
    public String solution(String[] seoul) {
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim"))
                return "김서방은 " + i + "에 있다";
        }
        return "default";
    }
}