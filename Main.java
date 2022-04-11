import 힙.이중우선순위큐.Solution;

public class Main {
    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};

        print(new Solution().solution(operations));
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
