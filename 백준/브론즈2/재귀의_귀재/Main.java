package 백준.브론즈2.재귀의_귀재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 재귀의 귀재
 * https://www.acmicpc.net/problem/25501
 *
 * 1. 팰린드롬 문자열을 앞뒤가 같은 문자열을 의미한다.
 * 2. 재귀를 이용해 팰린드롬 문자열인지 판별하는 메서드는 주어졌으므로 cnt 변수를 선언해서 재귀 호출 횟수만 세어주면 된다.
 *
 * @author 배용현
 */
public class Main {
    private static int cnt;     // 재귀 호출 횟수 count

    public static int recursion(String s, int l, int r) {       // 양 끝의 문자를 하나씩 비교하는 재귀로 팰린드롬 파악
        cnt++;      // 재귀 호출 횟수 count
        if(l >= r) return 1;        // 모든 문자에 대해 비교가 끝나면 true
        else if(s.charAt(l) != s.charAt(r)) return 0;       // 양 끝의 문자가 다르면 false
        else return recursion(s, l+1, r-1);     // 양 끝의 문자가 같으면 다음 재귀 호출
    }

    public static int isPalindrome(String s) {      // 문자열이 팰린드롬인지 확인해주는 함수
        return recursion(s, 0, s.length()-1);       // 적절히 파라미터를 주어 recursion 호출
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {        // 테스트케이스 개수만큼
            cnt = 0;        // cnt 초기화 이후
            System.out.println(isPalindrome(br.readLine()) + " " + cnt);        // isPalindrome 재귀 호출
        }
    }
}