package problems.dojo;

public class StackOfCoins {

	public int count(int n) {
		if(n == 1)
			return 1;
		else if(n == 0) 
			return 0;
		else
			return n + count(n -1);
	}

}
