package Report;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"가위", "바위", "보"};

        while (true) {
            System.out.print("가위, 바위, 보! (끝내려면 '그만'을 입력): ");
            String userChoice = scanner.nextLine();

            if (userChoice.equals("그만")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (!userChoice.equals("가위") && !userChoice.equals("바위") && !userChoice.equals("보")) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                continue;
            }

            int computerIndex = random.nextInt(3);
            String computerChoice = options[computerIndex];

            System.out.println("컴퓨터: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("비겼습니다!");
            } else if ((userChoice.equals("가위") && computerChoice.equals("보")) ||
                    (userChoice.equals("바위") && computerChoice.equals("가위")) ||
                    (userChoice.equals("보") && computerChoice.equals("바위"))) {
                System.out.println("사용자가 이겼습니다!");
            } else {
                System.out.println("컴퓨터가 이겼습니다!");
            }
        }
        scanner.close();
    }
}
