package Report;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print("곱하고자 하는 두 수 입력 : ");
                n = scanner.nextInt();
                m = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해주세요. 다시 시도하세요.");
                scanner.nextLine(); // 버퍼를 비워줌
            }
        }

        System.out.print(n + "x" + m + "=" + n * m);
        scanner.close();
    }
}

