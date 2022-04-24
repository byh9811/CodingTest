import 프로그래머스.고득점_Kit.정렬.가장_큰_수.Solution;

public class Main {
    public static void main(String[] args) {
        int[] int1DArr = {3, 30, 34, 5, 9};
        int[][] int2DArr = {
                {1, 2, 3},
                {4, 5, 6}
        };

        String[] str1DArr = {"N~F=0", "R~T>2"};
        String[][] str2DArr = {
                {"a", "b", "c"},
                {"d", "e", "f"}
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

        print(new Solution().solution(int1DArr));
    }

    private static void print(Object[][] arr) {
        for(Object[] elem: arr) {
            for(Object elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(Object[] arr) {
        for(Object elem: arr) {
            System.out.print(elem + " ");
        }
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
