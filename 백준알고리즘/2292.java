import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 1;
		int count = 1;

		while (n > sum) {
			sum += count * 6;
			count++;
		}
		System.out.println(count);
	}

}
