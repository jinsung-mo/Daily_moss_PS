import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 더미의 개수 N 입력
        int n = sc.nextInt();
        int[] hayBales = new int[n];
        int totalSum = 0;

        // 2. 건초 더미 높이 입력 및 전체 합계 계산
        for (int i = 0; i < n; i++) {
            hayBales[i] = sc.nextInt();
            totalSum += hayBales[i];
        }

        // 3. 평균 높이 계산
        int average = totalSum / n;
        int moves = 0;

        // 4. 평균보다 큰 더미에서 옮겨야 할 건초 개수 누적
        for (int i = 0; i < n; i++) {
            if (hayBales[i] > average) {
                moves += (hayBales[i] - average);
            }
        }

        // 5. 결과 출력
        System.out.println(moves);
        
        sc.close();
    }
}