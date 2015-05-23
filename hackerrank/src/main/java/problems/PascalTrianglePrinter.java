package problems;

import java.util.ArrayList;
import java.util.List;


public class PascalTrianglePrinter {

	public static void main(String[] args) {
		print(0);
		print(2);
		print(3);
		print(5);
	}
	
	public static void print(int n) {
		System.out.println("Printing Pascals triange for n=" + n);
		PascalTriangle pt = PascalTriangle.create(n);
		pt.rows.stream()
		           .forEach(System.out::println);
			
	}

	

	public static class PascalTriangle {
		private List<List<Integer>> rows = new ArrayList<List<Integer>>();
		
		static PascalTriangle create(int n) {
			PascalTriangle triangle = new PascalTriangle(); 
			for(int i = 0; i <= n; i++) {
				List<Integer> row = new ArrayList<Integer>();
				row.add(1);
				for(int j = 1; j < i; j++) {
					List<Integer> prevRow = triangle.rows.get(i - 1);
					row.add(prevRow.get(j-1) + prevRow.get(j));
				}
				if(i!=0) {
					row.add(1);
				}
				triangle.rows.add(row);
			}
			return triangle;
		}
	}
}
