 package kokoelmat;

public class EqualsExample {
	class P {
		String name = "";
		public P(String name) {
			this.name = name;
		}
		
		/**
		 * Huom!
		 * 
		 * 1. equals()in parametri on Object-tyyppiŠ
		 * 
		 */
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null) return false;
			
			// geneerisempi vaihtoehto 
			// getClass().isInstance(o)
			if( o instanceof P ) {
				return this.name == ((P)o).name; // o joudutaan tyyppimŠŠrittelemŠŠn
			}
			return false;
		}
		/**
		 * toString() metodi palauttaa olion String-muodon, jota voidaan kŠyttŠŠ
		 * esim. tulostettaessa olio System.out.println()-funktiolla
		 */
		@Override
		public String toString() {
			return name;
		}
	}
	
	public static void main(String args[]) {
		P a = new EqualsExample().new P("a");
		P b = new EqualsExample().new P("a");
		System.out.println(a==b); // oletus muistipaikkavertailu -> false
		System.out.println(a.equals(a)); // sisŠltšvertailu -> true
		// integer ja string osaavat viitata suoraan ilman equals()-funktion ylikirjoittamista
		System.out.println(new Integer(1).equals(new Integer(1))); 
	}
}
