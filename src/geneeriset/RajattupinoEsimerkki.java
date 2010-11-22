package geneeriset;

public class RajattupinoEsimerkki {
	public static void main(String[] args) {
		// Integer-pino
		Rajattupino<Integer> iPino = new Rajattupino<Integer>(10);
		Integer iObj = new Integer(15);
		iPino.laita(iObj); // aitio olio pinoon
		iPino.laita(20); // tässä tapahtuu automaattinen käärintä
		while(!iPino.onTyhja()) {
			iObj = iPino.ota();
			System.out.printf("Otin luvun %d%n", iObj);
		}
		
		Rajattupino<String> sPino = new Rajattupino<String>(10);
		sPino.laitaKaikki("pää", "oma");
		while(!sPino.onTyhja()) {
			String mj = sPino.ota();
			System.out.printf("Otin luvun %s%n", mj);
		}
	}
}
