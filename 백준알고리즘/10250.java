import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> roomNumber = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int y = 0; y < t; y++) {
			int h = sc.nextInt(); int w = sc.nextInt(); int n = sc.nextInt();
			int count = 1;
			
			for (int i = 1; i <= w; i++) {
				for (int j = 1; j <= h; j++) {
					if (n == count) {
						if (i < 10) {
							roomNumber.add(j + "0" + i);
						} else {
							roomNumber.add(j + "" + i);
						}
					}
					count++;
				}
			}
		}

		for (int x = 0; x < roomNumber.size(); x++) {
			System.out.println(roomNumber.get(x));
		}

	}// main

}
