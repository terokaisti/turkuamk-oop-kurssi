package kokoelmat;

import kokoelmat.EqualsExample.P;

/**
 * Lasketaan hashCoden eri arvoja
 * 
 * @author tero
 *
 */
public class HashcodeExample {
	// Logical consequence is that inner classes cannot declare enums. -Ken Blair
	enum Gender { MALE, FEMALE };
	
	// laajennetaan EqualsEsimerkki.P sisŠltŠmŠŠn myšs hashCode
	class P extends EqualsExample.P {

		public P(EqualsExample equalsExample, String name) {
			equalsExample.super(name);
		}
		public P(EqualsExample equalsExample, 
				String name, 
				Gender gender,
				double height) {
			equalsExample.super(name);
			this.gender = gender;
			this.height = height;
		}
		private Gender gender;
		private double height;
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(obj == null || !getClass().isInstance(obj) ) return false;
			
			P test = (P) obj; // Olio on varmasti tyyppiŠ P
			return 	height == test.height &&
					(name == test.name || (name != null && name.equals(test.name))) && 
					(gender == test.gender || (gender != null && gender.equals(test.gender)) );
			
		}
		
		// 1. ei mŠŠritelty
		
		/*
		// 2. HashCode aina sama
		public int hashCode() {
			return 0;
		}
		*/
		
		// 3. HashCode laskettu oliolle "erŠŠn periaatteen" mukaan
		// SŠŠnnšstš http://www.technofundo.com/tech/java/equalhash.html tai kirja s. 288
		public int hashCode() {
			int hash = 7; // valitaan "umpimŠhkŠŠn" pienehkš alkuluku
			int prime = 31; // valitaan "umpimŠhkŠŠn" toiseksi hieman isompi noin 20-50 vŠliltŠ oleva alkuluku
			
			// kŠydŠŠn muuttujat lŠpi sŠŠnnšstšn mukaisesti
			hash = prime * hash + (name == null ? 0 : name.hashCode()); // String (kŠytetŠŠn sŠŠntšŠ f.)
			hash = prime * hash + (gender == null ? 0 : gender.hashCode()); // enum (kŠytetŠŠn sŠŠntšŠ f.)
			
			// double (kŠyetŠŠn sŠŠntšŠ d.)
			long bits = Double.doubleToLongBits(height);
			hash = prime * hash + (int) (bits ^ (bits >>> 32));

			return hash;
		}
		@Override
		public String toString() {
			return name+
			(gender != null ? " "+gender : "") +
			(height > 0 ? " "+height : "" ); 
		}
	}
	public static P createTero() {
		return new HashcodeExample().new P(new EqualsExample(), "tero", Gender.MALE, 1.73);
	}
	
	public static void main(String args[]) {
		P a = createTero();
		P b = createTero();
		System.out.println(a.equals(b));
	}
}
