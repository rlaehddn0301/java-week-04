package Report;

import java.util.Random;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        Random random = new Random();

        // 배열에 1에서 10까지의 랜덤 정수 저장
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = random.nextInt(10) + 1;
            }
        }

        // 2차원 배열 출력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

