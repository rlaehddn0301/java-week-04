package Report;

import java.util.Scanner;

public class ReverseAlphabetPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("소문자 알파벳을 입력하세요: ");
        char input = scanner.next().charAt(0);

        int n = input - 'a' + 1;
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print((char)('a' + j));
            }
            System.out.println();
        }
        scanner.close();
    }
}
