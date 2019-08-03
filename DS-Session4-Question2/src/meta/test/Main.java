package meta.test;

import meta.utility.UniqueChar;

public class Main {
	public static void main(String[] args) {
		UniqueChar unique = new UniqueChar();
		int val = unique.countUniqueCharacters("itsAbhi");
		System.out.println(val);
		val = unique.countUniqueCharacters("Yashii");
		System.out.println(val);
		val = unique.countUniqueCharacters("itsAbhi");
		System.out.println(val);
	}
}
