package geneeriset;

public interface Pino<T> {
	public boolean onTyhja();
	public boolean onTaysi();
	/** Lis�� olion pinon p��llimm�iseksi **/
	public void laita(T o);
	public void laitaKaikki(T ... o );
	/** Ottaa pinon p��llimm�isen olion **/
	public T ota();
}
