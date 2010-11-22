package innerclass;

public class InnerClass2 {
	int[] numbers = {1,2,3};
	public class IntIterImpl {
		private int next = 0; // seuraava
		public boolean hasNext() {
			return next < numbers.length;
		}
		public int next() {
			return numbers[next++];
		}
	}
	public static void main(String[] args) {
		IntIterImpl it = new InnerClass2().new IntIterImpl();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
