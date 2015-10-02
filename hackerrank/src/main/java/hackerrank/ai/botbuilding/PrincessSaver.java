package hackerrank.ai.botbuilding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincessSaver {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		String[] input = new String[n];
		for (int i = 0; i < input.length; i++) {
			String row = scanner.next();
			input[i] = row;
		}
		
		Matrix matrix = new Matrix(input);
		matrix.findPath();
		
		scanner.close();
	}
	
	static class Matrix {
		 final String[] rows;
		  Coordinate princessCoordinate;
		  Coordinate saviourCoordinate;
		
		public Matrix(String[] rows) {
			this.rows = rows;
			detectPrincessAndSaviourCoordinates();
		}
		
		private void detectPrincessAndSaviourCoordinates() {
			for (int i = 0; i < rows.length; i++) {
				char[] elements = rows[i].toCharArray();
				for (int j = 0; j < elements.length; j++) {
					if('m' == elements[j]) {
						saviourCoordinate = new Coordinate(i, j);
					}else if('p' == elements[j]) {
						princessCoordinate = new Coordinate(i, j);
					}
				}
			}
		}
		
		public Coordinate distanceBetweenSaviourAndPrincess() {
			return new Coordinate((princessCoordinate.x - saviourCoordinate.x), (princessCoordinate.y - saviourCoordinate.y));
		}

		public List<String> findPath() {
			List<String> path = new ArrayList<String>();
			Coordinate distance = distanceBetweenSaviourAndPrincess();
			
			//Travel vertical distance
			for(int i = 0; i < Math.abs(distance.x); i++) {
				String move = "DOWN";
				if(distance.x < 0) {
					move = "UP";
				}
				path.add(move);
				System.out.println(move);
			}
			
			//Travel horizontal distance
			for(int i = 0; i < Math.abs(distance.y); i++) {
				String move = "RIGHT";
				if(distance.y < 0) {
					move = "LEFT";
				}
				path.add(move);
				System.out.println(move);
			}
			
			return path;
		}
	}
	
	static class Coordinate {
		final int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			Coordinate other = (Coordinate) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Coordinate [x=" + x + ", y=" + y + "]";
		}
	}
}
