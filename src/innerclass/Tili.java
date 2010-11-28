package innerclass;

public interface Tili {
	public Summa saldo();
	public interface Summa {
		public int getEurot();
		public int getSentit();
	}
}
class Tyhjatasku implements Tili {
	private int sentit;
	private int eurot;
	
	public Tyhjatasku() {}
	public Tyhjatasku(int eurot, int sentit) {
		this.eurot = eurot;
		this.sentit = sentit;
	}
	
	/**
	 * KotitehtŠvŠ 25.11
	 * 
	 * @param raha
	 */
	public Tyhjatasku(String raha) {
		String[] rahat = raha.split(",");
		this.eurot = new Integer(rahat[0]);
		this.sentit = Integer.parseInt(rahat[1]);
	}
	@Override
	public Tili.Summa saldo() {
		return new Tili.Summa() {
			
			@Override
			public int getSentit() {
				return sentit;
			}
			
			@Override
			public int getEurot() {
				return eurot;
			}
		};
	}
}