package problems;

import java.util.stream.IntStream;


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

	protected void printCornerPoints(int[][] input, StringBuilder sb, int x1, int y1, int x2, int y2) {
		printTopRow(input, sb, x1, y1, y2);
		printRigthColumn(input, sb, x1, x2, y2);
		if (printOnlyOneRow(x1, x2)) {
			printBottomRow(input, sb, y1, x2, y2);
		}
		if (printOnlyOneColumn(y1, y2)) {
			printLeftColumn(input, sb, x1, y1, x2);
		}
	}

	private void printTopRow(int[][] input, StringBuilder sb, int x1, int y1, int y2) {
		IntStream.rangeClosed(y1, y2)
		 		 .forEach(i -> appendCell(input, sb, x1, i));
	}
	
	private void printRigthColumn(int[][] input, StringBuilder sb, int x1, int x2, int y2) {
		IntStream.rangeClosed(x1 + 1, x2) 
				  .forEach(i -> appendCell(input, sb, i, y2));
	}
	
	private void printBottomRow(int[][] input, StringBuilder sb, int y1, int x2, int y2) {
		for (int i = (y2 - 1); i >= y1; i--) {
			appendCell(input, sb, x2, i);
		}
	}
	
	private void printLeftColumn(int[][] input, StringBuilder sb, int x1, int y1, int x2) {
		for (int i = (x2 - 1); printOnlyOneColumn(x1, i); i--) {
			appendCell(input, sb, i, y1);
		}
	}

	private boolean printOnlyOneColumn(int y1, int y2) {
		return y2 > y1;
	}

	private boolean printOnlyOneRow(int x1, int x2) {
		return printOnlyOneColumn(x1, x2);
	}
	
	private void appendCell(int[][] input, StringBuilder sb, int x, int y) {
		 sb.append(input[x][y])
		   .append(" ");
	}
}
