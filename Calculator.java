import java.util.Scanner;
public class Calculator {
    public double factorial(int n){
        if (n < 0){
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        if(n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n-1);
    }
    public double binomialCoefficient(int n, int k){
        if ( k < 0 || k > n){
            throw new IllegalArgumentException("Input values must be non-negative and k must be less than or equal to n");
        }
        if (k > n/2) k = n - k;  // Adjust k to be less than or equal to n/2 for efficiency.
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        double factor = calc.factorial(n);
        System.out.println("Factorial: " + factor);
        double binomialCoefficient = calc.binomialCoefficient(n, k);
        System.out.println("Binomial coefficient: " + binomialCoefficient);
    }

}
