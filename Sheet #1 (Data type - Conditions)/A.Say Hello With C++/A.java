import java.util.Scanner;
/*
    @SaifDemos
*/
public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner object

        String S = input.nextLine(); // Store the input in a variable

        System.out.println("Hello, " + S); // Cocatinat Hello with the variable in the print
        input.close();
    }
}
