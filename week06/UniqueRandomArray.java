package Report;

import java.util.Scanner;
import java.util.Random;

public class UniqueRandomArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("배열에 저장할 정수의 개수(100보다 작은 수)를 입력하세요: ");
        int count = scanner.nextInt();

        if (count >= 100) {
            System.out.println("100보다 작은 수를 입력해주세요.");
            return;
        }

        int[] array = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int num;
            do {
                num = random.nextInt(100) + 1;
            } while (isDuplicate(array, num, i));
            array[i] = num;
        }

        System.out.print("배열에 든 숫자들: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // 배열 내 중복 여부 확인
    private static boolean isDuplicate(int[] array, int num, int index) {
        for (int i = 0; i < index; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }
}

