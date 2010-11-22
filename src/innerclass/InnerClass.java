package innerclass;

public class InnerClass {
	private int[] numbers = {1,2,3};
	private class IntIterImpl {
		private int next = 0; // seuraava
		public boolean hasNext() {
			return next < numbers.length;
		}
		public int next() {
			return numbers[next++];
		}
	}
	public int[] getNumbers() {
		int[] _numbers = new int[numbers.length];
		int i = 0;
		IntIterImpl impl = new IntIterImpl();
		while(impl.hasNext())
			_numbers[i++] = impl.next();
		_numbers[0] = 2; // virhe
		return _numbers;
	}
	public static void main(String args[]) {
		InnerClass ic = new InnerClass();
		int a[] = ic.getNumbers();
		int b[] = ic.numbers;

		int i = a.length;
		while(i-->0)
			assert a[i] == b[i] : "Virhe "+a[i]+" != "+b[i];
	}
}
