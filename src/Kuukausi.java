
public class Kuukausi {
	int kuukausi = 1;
	public void lisaa(int lkm) {
		if(lkm<0) throw new IllegalArgumentException("LisŠys ei voi olla negatiivinen");
		if(kuukausi+lkm>12) throw new IllegalArgumentException("Ei voi lisŠtŠ nŠin paljon");
		int vanhaKuukausi = kuukausi;
		kuukausi += lkm;
		kuukausi++; // tahallinen virhe, tuo esiin assertin toiminnan
		// varmistetaan metodin oikea toiminta
//		assert kuukausi-lkm == vanhaKuukausi;
		// seka luokan invariantit
		assert invariant(): "Invariantti ei pidŠ paikkaansa";
	}
	private boolean invariant() {
		return (kuukausi >= 1 && kuukausi <= 12);
	}
	public static void main(String[] args) {
		Kuukausi k = new Kuukausi();
		k.lisaa(new Integer(args[0]));
	}
}
