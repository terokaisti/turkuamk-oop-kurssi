package geneeriset.laskin;
public class IntCalcMain {
	public static void main(String[] args) {
		Calculator<Integer> c = new CalcImpl();
		System.out.println(  c.add(10, 5) +" == " + 15 );
		
		System.out.println(  c.factorial(3) + " == " + 6 ); // 3+2+1 = 6
		
		NumberPino<Integer> p = new NumberPino<Integer>(10);
		p.laitaKaikki(1,2,3);
		
		System.out.println( c.sum(p)+ " == " + 6 );
	}
}

