package hackerrank;

public class UtopianTree {

	public int projectedHeight(int cycles) {
		int height = 1;
		for (int i = 1; i <= cycles; i++) {
			if (i%2 != 0) {
				height += height;
			} else {
				height += 1;
			}
		}
		return height;
	}

}
