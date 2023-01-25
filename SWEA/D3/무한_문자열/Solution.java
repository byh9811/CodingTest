package SWEA.D3.무한_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. 무한 반복 문자열이 같기 위한 조건은 중복 문자열을 제거하는 방식으로 압축했을때 압축한 문자열이 같아야한다.
 * 2. 압축하긴 어려우므로 최소 공배수만큼 늘려서 비교한다.
 * 3. 최소공배수를 문자열의 길이로 나눈 만큼 문자열을 반복하고 두 문자열을 비교한다.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=TC; test_case++) {
            String[] input = br.readLine().split(" ");
            String s = input[0];
            String t = input[1];

            int lcm = getLCM(s.length(), t.length());
            StringBuilder sbs = new StringBuilder();
            for(int i=0; i<lcm/s.length(); i++) {
                sbs.append(s);
            }

            StringBuilder sbt = new StringBuilder();
            for(int i=0; i<lcm/t.length(); i++) {
                sbt.append(t);
            }

            System.out.printf("#%d %s\n", test_case, sbs.toString().equals(sbt.toString()) ? "yes" : "no");
        }
    }

    // 둘 곱하고 GCD로 나누면 LCM임
    private static int getLCM(int s, int t) {
        return s * t / getGCD(s, t);
    }

    // GCD는 재귀함수로 구할 수 있음
    private static int getGCD(int max, int min) {
        int remain = max % min;
        return remain==0 ? min : getGCD(min, remain);
    }
}
