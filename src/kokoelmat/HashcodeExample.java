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
	
	// laajennetaan EqualsEsimerkki.P sis�lt�m��n my�s hashCode
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
			
			P test = (P) obj; // Olio on varmasti tyyppi� P
			return 	height == test.height &&
					(name == test.name || (name != null && name.equals(test.name))) && 
					(gender == test.gender || (gender != null && gender.equals(test.gender)) );
			
		}
		
		// 1. ei m��ritelty
		
		/*
		// 2. HashCode aina sama
		public int hashCode() {
			return 0;
		}
		*/
		
		// 3. HashCode laskettu oliolle "er��n periaatteen" mukaan
		// S��nn�st� http://www.technofundo.com/tech/java/equalhash.html tai kirja s. 288
		public int hashCode() {
			int hash = 7; // valitaan "umpim�hk��n" pienehk� alkuluku
			int prime = 31; // valitaan "umpim�hk��n" toiseksi hieman isompi noin 20-50 v�lilt� oleva alkuluku
			
			// k�yd��n muuttujat l�pi s��nn�st�n mukaisesti
			hash = prime * hash + (name == null ? 0 : name.hashCode()); // String (k�ytet��n s��nt�� f.)
			hash = prime * hash + (gender == null ? 0 : gender.hashCode()); // enum (k�ytet��n s��nt�� f.)
			
			// double (k�yet��n s��nt�� d.)
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
