package Report;

public class WhileTest {
    public static void main(String[] args) {
        int sum=0, i=1;
        while (i < 100) {
            sum = sum + i;
            i+=2;
        }
        System.out.println(sum);
    }
}

