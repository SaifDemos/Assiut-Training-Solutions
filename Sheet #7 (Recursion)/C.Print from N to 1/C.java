import java.util.Scanner;
/*
    @SaifDemos
*/
public class C {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        int x = input.nextInt(); // the N number
        space(x);
    } 


    public static int space(int x){
        if(x == 0){ // base case 1
            return 0;
        }
        else if(x>1000){ // base case 2
            return 0;
        }
        System.out.print(x);
        if (x == 1) { // break point
            return 0;
        }
        System.out.print(" "); // used [print] not [println] to be on the same line
        return space(x-1); // call again but with the number -1
    }
}