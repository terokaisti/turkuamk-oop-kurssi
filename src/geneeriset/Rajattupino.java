package geneeriset;

public class Rajattupino<T> implements Pino<T>{

	private int koko = 0;
	private T[] oliot;
	
	public Rajattupino(int maxkoko) {
		oliot = (T[]) new Object[maxkoko];
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
	public void laita(T o) {
		oliot[koko++] = o;
	}

	@Override
	public void laitaKaikki(T... objects) {
		for (int i = 0; i < objects.length; i++)
			laita(objects[i]);
	}
	
	@Override
	public T ota() {
		T obj = oliot[--koko];
		oliot[koko] = null;
		return obj;
	}

}
