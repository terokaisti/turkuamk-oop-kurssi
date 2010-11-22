package innerclass;

public interface Tili {
	public Summa saldo();
	public interface Summa {
		public int getEurot();
		public int getSentit();
	}
}
class Tyhjatasku implements Tili {
	@Override
	public Tili.Summa saldo() {
		return new Tili.Summa() {
			
			@Override
			public int getSentit() {
				return 0;
			}
			
			@Override
			public int getEurot() {
				return 0;
			}
		};
	}
}