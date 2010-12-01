package kokoelmat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import sun.tools.tree.LengthExpression;

import kokoelmat.HashcodeExample.Gender;
import kokoelmat.HashcodeExample.P;

/**
 * HashSet on kokoelma joukolle olioita, joiden equals-metodi palauttaa falsen
 * kaikille verrokkiolioille
 * 
 * @author tero
 *
 */
public class HashSetExample {
	class A {
		public boolean equals(Object o) { return true; } // -> 1, false -> 3
		public int hashCode() { return 1; } // remove -> aina 3
	}
	
	public static void main(String args[]) {
		duplicateLetters();
		duplicatePersons();
		
		HashSet<A> ha = new HashSet<A>(Arrays.asList(
				new HashSetExample().new A(), 
				new HashSetExample().new A(), 
				new HashSetExample().new A()
			));
		System.out.println(ha.size());
		
	}

	private static void duplicatePersons() {
		Set<P> noDuplicates = new HashSet<P>();

		Object[][] family = 
		{
				{"Tero", HashcodeExample.Gender.MALE, 1.73 },
				{"PŠivi", HashcodeExample.Gender.FEMALE, 1.70 },
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
