package Report;

import java.util.Random;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        // 배열에 1에서 10까지의 랜덤 정수 저장
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        // 배열에 든 숫자들 출력
        System.out.print("배열에 든 숫자들: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // 평균 계산
        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = sum / array.length;
        System.out.println("\n평균: " + average);
    }
}

