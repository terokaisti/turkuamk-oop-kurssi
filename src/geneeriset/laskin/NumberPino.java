package geneeriset.laskin;
public class NumberPino<Integer> implements Pino<Number>{

	private int koko = 0;
	private Number[] oliot;
	
	public NumberPino(int maxkoko) {
		oliot = (Number[]) new Object[maxkoko];
	}
	
	@Override
	public boolean onTyhja() {
		return koko == 0;
	}

	@Override
	public boolean onTaysi() {
		return oliot.length == koko;
	}

	@Override
	public void laita(Number o) {
		oliot[koko++] = o;
	}

	@Override
	public void laitaKaikki(Number... objects) {
		for (int i = 0; i < objects.length; i++)
			laita(objects[i]);
	}
	
	@Override
	public Number ota() {
		Number obj = oliot[--koko];
		oliot[koko] = null;
		return obj;
	}

}

