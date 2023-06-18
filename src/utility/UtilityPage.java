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
	
	public static void changePage() {
		for(int i=0; i<30; i++) {
			System.out.println();
		}
	}
	
	public static void enterToContinue() {
		System.out.println("Press Enter to Continue");
		scan.nextLine();
	}
}
