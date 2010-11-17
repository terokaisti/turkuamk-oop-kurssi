

public class Debugattava {
    private int alku;
	public Debugattava(int i) { this.alku = i; }
    public int summa() {
        int i = this.alku; 
        int summa = 0;
        while(i-->0) summa += i;
        return summa;
    }
    public int kertoma(int i) {
        int kertoma = summa();
        while(i-- >0) kertoma *= i;
        return kertoma;
    }
    public static void main(String[] args) {
        Debugattava d = new Debugattava (4);
        int s = d.summa();
        int k = d.kertoma(3);
        System.out.println(s+" " +k);
        assert s == 5: "Virhe";
    }
}