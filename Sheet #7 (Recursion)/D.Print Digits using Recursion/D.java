import java.util.Scanner;
/*
    @author SaifDemos
*/
public class D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder finalOutput = new StringBuilder(); // Use a StringBuilder to store ALL output lines efficiently
        int x = input.nextInt(); // the N number of test cases
 
        for (int i = 0; i < x; i++) {
            int N = input.nextInt(); // Read the current number N
            
            String resultLine;
            if (N == 0) {
                resultLine = "0 "; // Handle the special case N=0
            } else {
                resultLine = printDigits(N); // Call the recursive function, which returns the digit string
            }
            
            // Append the result string and a newline to the buffer
            // We use .trim() to remove the trailing space from the end of the line
            finalOutput.append(resultLine.trim()).append("\n");
        }
        
        System.out.print(finalOutput.toString()); // Print the entire accumulated output at the very end
        input.close();
    }
 

    public static String printDigits(int N) { // Recursive Function Returns the formatted digit string
        if (N == 0) { // Base case
            return "";
        }
 
        // Recursive Step: 
        // 1. Get the string of digits for the remaining part (N / 10). (e.g. 121/10 = 12)
        String leadingDigits = printDigits(N / 10);
        
        // 2. Get the current last digit (N % 10) followed by a space. (e.g 121%10 = 3 )
        String currentDigit = (N % 10) + " ";
 
        // 3. Combine and return the whole sequence.
        // This is the key to printing in the correct order.
        return leadingDigits + currentDigit;
    }
}