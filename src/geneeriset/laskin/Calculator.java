package geneeriset.laskin;
/**
 * Kotiteht�v�:
 * 
 * Implementoi rajapintaa vastaan Integer-tyyppinen luokka. 
 * Kirjoita pari esimerkki� jotka testaavat luokan toimivuutta.
 * 
 * @author tero
 *
 * @param <T>
 */
public interface Calculator<T extends Number> {
	/**
	 * Laskee a:n ja b:n summan ja palauttaa sen
	 * 
	 * @param a Number
	 * @param b Number
	 * @return Number
	 */
	public T add(T a, T b);

	/**
	 * Laskee a:n kertoman ja palauttaa sen
	 * 
	 */
	public T factorial(T a);

	@SuppressWarnings("hiding")
	public <T extends Number> double sum(Pino<T> pino);
}


