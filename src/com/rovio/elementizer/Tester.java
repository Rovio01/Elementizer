package com.rovio.elementizer;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		if (args.length!=0) {
			System.out.println(Elementizer.getElementSymbols(args[0]));
			System.out.println(Elementizer.getElementNames(args[0]));
		}
		else {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter a string you would like Elementized:");
			System.out.println("Note that only the first word you enter will be processed.");
			String word=scan.next();
			String out=Elementizer.getElementSymbols(word);
			System.out.println(out);
			if (out.equals("No possible combination of elements found.")) {
				scan.close();
				return;
			}
			System.out.println(Elementizer.getElementNames(word));
			scan.close();
		}
	}

}