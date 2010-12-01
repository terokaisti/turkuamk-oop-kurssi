package kokoelmat;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorExample {
	class I implements Collection<String>, Iterable<String> {
		
		private int n = 0;
		String[] c = new String[10];
		
		@Override
		public Iterator<String> iterator() {
			return new Iterator<String>() {

				private int n = 0;
				
				@Override
				public boolean hasNext() {
					return n < c.length && c[n] != null;
				}

				@Override
				public String next() {
					return c[n++];
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}
		@Override
		public boolean add(String e) {
			throw new UnsupportedOperationException();
		}
		private boolean _add(String e) {
			if(n==c.length) 
				return false;
			c[n++] = e;
			return true;
			
		}
		@Override
		public boolean addAll(Collection<? extends String> c) {
			Iterator<String> i = (Iterator<String>) c.iterator();
			while(i.hasNext() && _add((String) i.next()));
			return true;
			
		}
		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean contains(Object o) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean containsAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean isEmpty() {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public int size() {
			throw new UnsupportedOperationException();
		}
		@Override
		public Object[] toArray() {
			throw new UnsupportedOperationException();
		}
		@Override
		public <T> T[] toArray(T[] a) {
			throw new UnsupportedOperationException();
		}
	}
	public static void main(String args[]) {
		String[] s = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l"};
		I c = new IteratorExample().new I();
		c.addAll(Arrays.asList(s));
		Iterator i = c.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
}
