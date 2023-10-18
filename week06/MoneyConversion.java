package Report;

import java.util.Scanner;

public class MoneyConversion {
    public static void main(String[] args) {
        int[] units = {50000, 10000, 1000, 500, 100, 50, 10, 1};
        String[] unitNames = {"오만 원권", "만 원권", "천 원권", "500원짜리 동전", "100원짜리 동전", "50원짜리 동전", "10원짜리 동전", "1원짜리 동전"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("정수로 된 돈의 액수를 입력하세요: ");
        int money = scanner.nextInt();

        System.out.println("입력한 액수를 화폐로 변환하면 다음과 같습니다:");
        for (int i = 0; i < units.length; i++) {
            int count = money / units[i];
            if (count > 0) {
                System.out.println(unitNames[i] + " : " + count + "개");
                money %= units[i];
            }
        }
        scanner.close();
    }
}

