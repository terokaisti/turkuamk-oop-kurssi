package geneeriset;

public interface Pino<T> {
	public boolean onTyhja();
	public boolean onTaysi();
	/** LisŠŠ olion pinon pŠŠllimmŠiseksi **/
	public void laita(T o);
	public void laitaKaikki(T ... o );
	/** Ottaa pinon pŠŠllimmŠisen olion **/
	public T ota();
}
