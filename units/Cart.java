package units;
import java.util.Scanner;
public class Cart {
public static void main (String[]args){
	Scanner sc=new Scanner(System.in);
	TotalAmount t=new TotalAmount();
	System.out.println("How many item do you need?");
	int i= sc.nextInt();
	System.out.println("Price of each item?");
	int j=sc.nextInt();
	int total= t.cart(i, j);
	System.out.println("You have to pay: "+total);
}

}
