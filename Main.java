import Greedy.큰_수_만들기.Solution;

public class Main {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(new Solution().solution(number, k));
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
