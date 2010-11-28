package geneeriset.laskin;

public class CalcImpl implements Calculator<Integer> {

	@Override
	public Integer add(Integer a, Integer b) {
		return a+b;
	}

	@Override
	public Integer factorial(Integer a) {
		int i = 0;
		while(a-- > 0) {
			a *= i;
		}
		return i;
	}

	@Override
	public <T extends Number> double sum(Pino<T> pino) {
		Number i = (Number) new Object();
		int x = 0;
		while(!pino.onTyhja()) {
			x += pino.ota().intValue();
		}
		return x;
	}

//	@Override
//	public Integer sum(Pino<T> pino) {
//		T i = (T) new Object();
//		while(pino.onTaysi()) {
//			T x = pino.ota();
//			x = i+x;
//		}
//		return i;
//	}

	
	
}