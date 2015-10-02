import java.util.ArrayList;
import java.util.List;



public class GenericsDeclaration {

	public static void main(String[] args) {
		// \u000d System.out.println("Hello World!");
		String strJapanese = "日本語";
		String c = "\\u000d";
		System.out.println(c);
	}
	
	private <T extends Object> void add(List<T> l) {
	}
}
