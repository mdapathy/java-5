import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int a;
        int b;
        int m;
        int n;

        double result = 0;
        int exception = 2;

        Scanner input = new Scanner(System.in);

        try {

            System.out.print("Enter a : ");
            a = input.nextInt();

            System.out.print("Enter n : ");
            n = input.nextInt();

            System.out.print("Enter b : ");
            b = input.nextInt();

            System.out.print("Enter m : ");
            m = input.nextInt();

        } catch (Exception e) {

            System.out.println("Your value cannot be represented as int");
            return;
        }


        if (a > n || b > m) {

            System.out.println("The upper bound must be greater than "
                    +  " the lower bound. Cannot calculate. ");

        } else if (a + exception <= 0 && n + exception >= 0) {

            System.out.println("Cannot calculate because division"
                    + " by zero is involved!");

        } else {

            for (int i = a; i <= n; i++) {

                for (int j = b; j <= m; j++) {

                    result += (double) i / (i + exception) * j;

                }
            }

            System.out.println(result);

        }
    }
}
