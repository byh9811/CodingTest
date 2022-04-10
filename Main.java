import 그리디.구명보트.Solution;

public class Main {
    public static void main(String[] args) {
        int[] people = {240, 240, 240, 240, 240};

        System.out.println(new Solution().solution(people, 240));
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
