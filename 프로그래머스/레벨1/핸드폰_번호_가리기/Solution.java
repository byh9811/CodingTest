package 프로그래머스.레벨1.핸드폰_번호_가리기;

public class Solution {
    public String solution(String phone_number) {
        int asterNum = phone_number.length()-4;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<asterNum; i++)
            sb.append('*');

        sb.append(phone_number.substring(asterNum));

        return sb.toString();
    }
}