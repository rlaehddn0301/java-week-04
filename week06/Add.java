package Report;

public class Add {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("인자가 제공되지 않았습니다.");
            return;
        }

        int sum = 0;
        for (String arg : args) {
            try {
                sum += Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                // 정수로 변환할 수 없는 경우 무시
            }
        }
        System.out.println("합: " + sum);
    }
}

