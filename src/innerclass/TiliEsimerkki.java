package innerclass;

public class TiliEsimerkki {
	public static void main(String[] args) {
		Tyhjatasku tasku = new Tyhjatasku("10,5");
		System.out.println("Paalua l�ytyy "+tasku.saldo().getEurot()+"e ja "+tasku.saldo().getSentit()+"s");
	}
}
