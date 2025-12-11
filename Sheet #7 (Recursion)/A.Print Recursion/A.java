import java.util.Scanner;

/*
    @SaifDemos
*/
 
public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt(); // the N number
        System.out.println(print(x)); // calling the recursion
        // edited by Hussain
        System.out.println("End\n");
        System.out.println("OOP BY HUSSAIN AHMED AMR");
    }
 
 
    public static String print(int x) {
       if (x == 0) { // base case 1
        return "";
       } else if (x > 100) { // base case 2
        return "";
       }
       System.out.println("I love Recursion");
       return print(x-1); // reverse counter to hit base case after N times
    }
    
}