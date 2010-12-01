package kokoelmat;

import java.util.HashMap;
import java.util.Map;

import kokoelmat.HashcodeExample.P;

/**
 * Lasketaan hashCoden eri arvoja
 * 
 * @author tero
 *
 */
public class HashMapExample {
	// avain olio
	class K {
		private String name;
		public K(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return this.name;
		}
		
	}
	public static void main(String args[]) {
		Map<String, P> map = new HashMap<String, P>();
		map.put("a", HashcodeExample.createTero());
		map.put("b", HashcodeExample.createTero());
		map.put("b", HashcodeExample.createTero());
		System.out.print(map);
		
		// avain-olio ei implementoi hashCodea
		Map<K, P> map2 = new HashMap<K, P>();
		K k1 = new HashMapExample().new K("tero");
		map2.put(k1, HashcodeExample.createTero());
		// "oletus hashcode palauttaa muistipaikan"
		k1 = new HashMapExample().new K("tero");
		map2.put(k1, HashcodeExample.createTero());
		// -> aina eri hashcode, jota käytetään avaimena
		// ei välttämättä johda haluttuun lopputulokseen
		System.out.println(map2);
		
		// avain oliona toimii hashcoden implementoiva monimutkainen olio
		Map<P, Object> map3 = new HashMap<P, Object>();
		map3.put(HashcodeExample.createTero(), "a");
		map3.put(HashcodeExample.createTero(), "b");
		map3.put(HashcodeExample.createTero(), "c");
		System.out.println(map3);

		Map<P, P> married = new HashMap<P, P>();
		P tero = new HashcodeExample().new P(new EqualsExample(), "tero");
		P paivi = new HashcodeExample().new P(new EqualsExample(), "päivi");
		married.put(tero, paivi);
		married.put(paivi, tero);
		System.out.println("Married couples: "+married);
	}
}
