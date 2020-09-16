import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
		
		Scanner num = new Scanner(System.in);
		n = num.nextInt();
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
