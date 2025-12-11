import java.util.Scanner;
/*
    @author SaifDemos
*/
public class B {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        int x = input.nextInt(); // the N number
        count(x, 1);
    } 


    public static int count(int x, int y){
        if(x < y){ //base case 1
            return 0;
        }
        else if(x>1000){ // base case 2
            return 0;
        }
        System.out.println(y);
        return count(x, y+1); // call the method again with the counter +1
    }
}