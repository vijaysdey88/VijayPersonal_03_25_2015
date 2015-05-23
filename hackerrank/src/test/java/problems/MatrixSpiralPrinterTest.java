package problems;

import org.junit.Assert;
import org.junit.Test;



public class MatrixSpiralPrinterTest {
	private MatrixSpiralPrinter printer = new MatrixSpiralPrinter();
	
	private int[][] input = {{1,  2,  3,  4}, 
							 {5,  6,  7,  8},
							 {9,  10, 11, 12},
							 {13, 14, 15, 16}};
	
	private int[][] input1 = {{1,   2,  3,  4,  5,  6}, 
					 		  {7,   8,  9,  10, 11, 12},
					 		  {13,  14, 15, 16, 17, 18}};
	
	private int[][] input2 = {{1,  2,  3}, 
	 		  				  {4,  5,  6},
	 		  				  {7,  8,  9},
	 		  				  {10, 11, 12},
	 		  				  {13, 14, 15},
	 		  				  {16, 17, 18}};


	
	@Test
	public void shouldPrintTheCornerElementsOfInput() {
		assertPrintingCorner(input, new StringBuilder(), 0, 0, 3, 3, "1 2 3 4 8 12 16 15 14 13 9 5 ");
		assertPrintingCorner(input , new StringBuilder(), 1, 0, 3, 3, "5 6 7 8 12 16 15 14 13 9 ");
		assertPrintingCorner(input , new StringBuilder(), 1, 1, 2, 2, "6 7 11 10 ");
		
		assertPrintingCorner(input1, new StringBuilder(), 1, 1, 1, 4, "8 9 10 11 "); 
		assertPrintingCorner(input2, new StringBuilder(), 1, 1, 4, 1, "5 8 11 14 "); 
	}

	@Test
	public void shouldPrintSpirallyForSquareatrix() {
		String exp = "1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 ";
		Assert.assertEquals(exp, printer.print(input));
	}
	
	@Test
	public void shouldPrintSpirallyForRectangleMatrix() {
		String exp = "1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11 ";
		Assert.assertEquals(exp, printer.print(input1));
	}
	

	private void assertPrintingCorner(int[][] i, StringBuilder sb, int x1, int y1, int x2, int y2, String exp) {
		printer.printCornerPoints(i, sb, x1, y1, x2, y2);
		Assert.assertEquals(exp, sb.toString());
	}

}
