import DP.정수_삼각형.Solution;

public class Main {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(new Solution().solution(triangle));
    }

    private static void print(int[][] arr) {
        for(int[] elem: arr) {
            for(int elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(String[] arr) {
        for(String elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
