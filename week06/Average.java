package Report;

public class Average {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("인자가 제공되지 않았습니다.");
            return;
        }

        double sum = 0;
        for (String arg : args) {
            sum += Integer.parseInt(arg);
        }
        double average = sum / args.length;

        System.out.println("평균: " + average);
    }
}

