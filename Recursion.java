
import java.util.*;

public class Recursion {

    public static int findSum(int n, int sum) {
        if (n == 0) {
            return sum;
        }
        sum += n;
        return findSum(n - 1, sum);
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int power(int x, int y) {
        if (y == 0) {                             // if exponent is zero
            return 1;
        } else if (y == 1 || x == 0) {              //if exponent is 1 or base is 0
            return x;
        } else {
            return x * power(x, y - 1);
        }
    }

    public static int powerOptimized(int x, int y) {
        if (y == 0) {                             // if exponent is zero
            return 1;
        } else if (y == 1 || x == 0) {              //if exponent is 1 or base is 0
            return x;
        } else {
            int halfPower = powerOptimized(x, y / 2);     // calculating half power only because the other half will also be same 
            return y % 2 == 0 ? halfPower * halfPower : halfPower * halfPower * x;
        }
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println(n + " Disk transfered from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println(n + " Disk transfered from " + src + " to " + dest);
        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void checkSorted(int[] arr, int n, int i) {
        if(i == n-1){
            System.out.println("Array is sorted");
            return;
        }
        if (arr[i] >= arr[i + 1]) {
            System.out.println("Array is not sorted");
            return;
        } 
        checkSorted(arr, n, i + 1);
    }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ///-----------------------------------find sum of first n natural numbers----------------------------------
 
        // System.out.print("Enter a number upto which you want to find the sum : ");
        // int n = sc.nextInt();
        // int sum = findSum(n,0);
        // System.out.print("\nSum of " + n + " natural numbers = " + sum);


        ///-------------------------------finding factorial of a number n-------------------------------------------
        
        // System.out.print("Enter a number : ");
        // int n = sc.nextInt();
        // int fact = factorial(n);
        // System.out.print("Factoral of " + n + " = " + fact);


        ///----------------------------------fibonacci series-----------------------------------------------
        
        // System.out.print("Enter the term upto which you want to print fibonacci series : ");
        // int n = sc.nextInt();
        // for(int i = 0; i <= n; i++){
        //     System.out.print(fibonacci(i) + "\t");
        // }


        ///------------------------------------find power of a number (stack height = y)-----------------------------------------------
        
        // System.out.print("Enter the base number : ");
        // int x = sc.nextInt();
        // System.out.print("Enter the exponent : ");
        // int y = sc.nextInt();
        // int result = power(x, y);
        // System.out.print("Value of " + x + " to the power " + y + " = " + result);


        ///------------------------------------find power of a number (stack height = log y)-----------------------------------------------
        
        // System.out.print("Enter the base number : ");
        // int x = sc.nextInt();
        // System.out.print("Enter the exponent : ");
        // int y = sc.nextInt();
        // int result = powerOptimized(x, y);
        // System.out.print("Value of " + x + " to the power " + y + " = " + result);


        ///-----------------------------------tower of hanoi-------------------------------------------------------------
        
        // System.out.print("Enter the number of disks : ");
        // int n = sc.nextInt();
        // towerOfHanoi(n, "S", "H", "D");
    }
}