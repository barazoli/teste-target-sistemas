import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("informar um número: ");
        int num = scanner.nextInt();

        if (calculoFibonacci(num)) {
            System.out.println(num + ("faz parte da sequencia de Fibonnaci."));
        }
        else {
            System.out.println (num + "não faz parte da sequencia de Fibonacci.");
        }
    }
    
    public static boolean calculoFibonacci(int num) {
        int a = 0, b = 1, c = 0;
        while (c < num) {
            c = a + b;
            a = b;
            b = c;
        }
        return c == num || num == 0;
    }
}
