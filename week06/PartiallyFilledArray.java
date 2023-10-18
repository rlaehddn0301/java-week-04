package Report;

import java.util.Random;

public class PartiallyFilledArray {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        Random random = new Random();

        // 10개의 랜덤 정수를 임의 위치에 삽입
        for (int k = 0; k < 10; k++) {
            int i = random.nextInt(4);
            int j = random.nextInt(4);
            int num = random.nextInt(10) + 1;
            array[i][j] = num;
        }

        // 나머지 6개의 숫자는 모두 0
        for (int k = 0; k < 6; k++) {
            int i = random.nextInt(4);
            int j = random.nextInt(4);
            array[i][j] = 0;
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

