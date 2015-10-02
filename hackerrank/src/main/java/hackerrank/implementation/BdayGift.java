package hackerrank.implementation;

import java.util.Scanner;

public class BdayGift {

	public static long minSpend(Gift giftA, Gift giftB, long transferCost) {
		Gift cheaperOne = giftA;
		Gift costlierOne = giftB;
		if (giftB.price < giftA.price) {
			cheaperOne = giftB;
			costlierOne = giftA;
		}
		long totalTransferPrice = cheaperOne.price + transferCost;
		long minSecondPrice = totalTransferPrice < costlierOne.price ? totalTransferPrice : costlierOne.price;
		return cheaperOne.cost() + minSecondPrice * costlierOne.units;
	}

	public static class Gift {
		long price;
		long units;

		public Gift(long price, long units) {
			this.price = price;
			this.units = units;
		}

		public long cost() {
			return price * units;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long unitsA = scanner.nextLong();
		long unitsB = scanner.nextLong();
		long priceA = scanner.nextLong();
		long priceB = scanner.nextLong();
		long transfer = scanner.nextLong();
		System.out.println(minSpend(new Gift(priceA, unitsA), new Gift(priceB, unitsB), transfer));
		
		scanner.close();

	}
}
