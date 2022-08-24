import 유틸.Combination;
import 유틸.Utils;
import 프로그래머스.레벨3.브라이언의_고민.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] int1DArr = {1,2,3,4};
        int[] int1DArr2 = {3, 4};
        int[][] int2DArr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] int2DArr2 = {
                {3,4},
                {5,6}
        };

        String[] str1DArr = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[][] str2DArr = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };

        boolean[] bool1DArr = {true,false,true};
        boolean[][] bool2DArr = {
                {true, true, true},
                {false, false, false}
        };

        char[] char1DArr = {'a', 'b', 'c'};
        char[][] char2DArr = {
                {'a', 'a', 'a'},
                {'a', 'a', 'a'}
        };

        long[] long1DArr = {2,7};
        long[][] long2DArr = {
                {1,2},
                {3,4}
        };

        //print(new Solution().solution("AaABbBbB"));
        new Combination(int1DArr).combination(0, 4);
    }

    private static void print(Iterable<?> iterableObj) {
        for(Object obj: iterableObj)
            System.out.print(obj + " ");
    }

    private static void print(int answer) { System.out.println(answer); }
    private static void print(long answer) { System.out.println(answer); }
    private static void print(float answer) { System.out.println(answer); }
    private static void print(double answer) { System.out.println(answer); }
    private static void print(char answer) { System.out.println(answer); }
    private static void print(String answer) { System.out.println(answer); }
    private static void print(boolean answer) { System.out.println(answer); }

    private static void print(int[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(long[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(float[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(double[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(char[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(String[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(boolean[] answer) { System.out.println(Arrays.toString(answer)); }

    private static void print(int[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(long[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(float[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(double[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(char[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(String[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(boolean[][] answer) { System.out.println(Arrays.deepToString(answer)); }
}
