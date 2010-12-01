package kokoelmat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import kokoelmat.HashcodeExample.Gender;
import kokoelmat.HashcodeExample.P;

/**
 * HashSet esimerkkejä
 * 
 * @author tero
 *
 */
public class HashSetExample {
	public static void main(String args[]) {
		duplicateLetters();
		duplicatePersons();
	}

	private static void duplicatePersons() {
		Set<P> noDuplicates = new HashSet<P>();

		Object[][] family = 
		{
				{"Tero", HashcodeExample.Gender.MALE, 1.73 },
				{"Päivi", HashcodeExample.Gender.FEMALE, 1.70 },
				{"Tero", HashcodeExample.Gender.MALE, 1.73 },
				{"Viena", HashcodeExample.Gender.FEMALE, 0.61 }
		};
		
		for(Object[] member : family) {
			P p = new HashcodeExample().new P(
					new EqualsExample(), 
					(String) member[0], 
					(Gender) member[1], 
					(Double) member[2]
			);
			noDuplicates.add(p);
		}
		System.out.println(noDuplicates);
	}

	private static void duplicateLetters() {
		Set<String> noDuplicates = new HashSet<String>();

		String[] duplicates = {"a", "b", "a", "d"};
		int i = duplicates.length;
		for(String s : duplicates) {
			noDuplicates.add(s);
		}
		System.out.println(noDuplicates);
		
		noDuplicates.clear();
		
		noDuplicates.addAll(Arrays.asList("A", "B", "A", "D"));
		System.out.println(noDuplicates);
	}
}
