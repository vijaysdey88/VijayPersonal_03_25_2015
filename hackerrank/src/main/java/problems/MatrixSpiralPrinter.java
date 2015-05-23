package problems;

public class MatrixSpiralPrinter {

	public String print(int[][] input) {
		StringBuilder sb = new StringBuilder();
		int x1 = 0, y1 = 0, x2 = input.length - 1, y2 = input[0].length - 1;

		while ((x2 >= x1) & (y2 >= y1)) {
			printCornerPoints(input, sb, x1, y1, x2, y2);
			x1++; y1++; x2--; y2--;
		}

		return sb.toString();
	}

	public void printCornerPoints(int[][] input, StringBuilder sb, int x1, int y1, int x2, int y2) {
		for (int i = y1; i <= y2; i++) {
			sb.append(input[x1][i])
			  .append(" ");
		}
		
		for (int i = (x1 + 1); i <= x2; i++) {
			sb.append(input[i][y2])
			  .append(" ");
		}

		if (x2 > x1) {
			for (int i = (y2 - 1); i >= y1; i--) {
				sb.append(input[x2][i])
				  .append(" ");
			}
		}

		if (y2 > y1) {
			for (int i = (x2 - 1); i > x1; i--) {
				sb.append(input[i][y1])
				  .append(" ");
			}
		}
	}
}
