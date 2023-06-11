package utility;

import java.util.Scanner;

public class UtilityPage {
	private static Scanner scan = new Scanner(System.in);
	public static int getOption(int min, int max) {
		int opt = -1;
		do {
			System.out.print(" >> ");
			try {
				opt = scan.nextInt();
			} catch (Exception e) {
				opt = -1;
			}
			scan.nextLine();
		}while(opt < min || opt > max);
		return opt;
	}
}
