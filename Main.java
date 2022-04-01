import 스택_및_큐.주식가격.Solution;

public class Main {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 2, 3};

        print(new Solution().solution(answers));
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
