package Report;

import java.util.Scanner;

public class MultipleOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];

        System.out.println("양의 정수 10개를 입력하세요:");
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("입력된 배열에서 3의 배수는 다음과 같습니다:");
        for (int i = 0; i < 10; i++) {
            if (array[i] % 3 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        scanner.close();
    }
}

