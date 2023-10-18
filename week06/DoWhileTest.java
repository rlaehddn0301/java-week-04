package Report;

public class DoWhileTest {
    public static void main(String[] args) {
        int sum = 0, i = 1;
        do {
            sum += i;
            i += 2;
        } while (i < 100);
        System.out.println(sum);
    }
}

