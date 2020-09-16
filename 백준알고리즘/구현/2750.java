import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int i, j, temp;
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] a = new int[number];

		for (i = 0; i < number; i++) {
			a[i] = sc.nextInt();
		}

		for (i = 0; i < number; i++) {
			for (j = 0; j < number - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}

		}

		for (i = 0; i < number; i++) {
			System.out.println(a[i]);
		}

	}

}
