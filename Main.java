import 프로그래머스.레벨2.귤_고르기.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] int1DArr = {1, 1, 1, 1, 2, 2, 2, 3};
        int[] int1DArr2 = {3, 4};
        int[][] int2DArr = {
                {1,1,7,4},
                {3,2,5,5},
                {4,3,6,9},
                {2,6,8,8}
        };
        int[][] int2DArr2 = {
                {3,4},
                {5,6}
        };

        String[] str1DArr = {"A 6", "B 12", "C 3"};
        String[] str1DArr2 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
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

        // 백준용 실행문
//        new Solution().solution();

        // 프로그래머스용 실행문
        print(new Solution().solution(2, int1DArr));
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
