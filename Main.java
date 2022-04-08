import DP.등굣길.Solution;

public class Main {
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};

        System.out.println(new Solution().solution(4, 3, puddles));
    }

    private static void print(int[][] arr) {
        for(int[] elem: arr) {
            for(int elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(int[] arr) {
        for(int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
