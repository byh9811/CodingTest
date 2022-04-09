import 해시.전화번호_목록.Solution;

public class Main {
    public static void main(String[] args) {
        String[] puddles = {"119", "97674223", "1195524421"};

        System.out.println(new Solution().solution(puddles));
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
