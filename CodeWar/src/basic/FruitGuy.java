package basic;

public class FruitGuy {
	public static String[] removeRotten(String[] fruitBasket) {
		if (fruitBasket == null || fruitBasket.length == 0) return new String[0];
		
//		for (String fruit : fruitBasket) {
//			fruit = fruit.replaceAll("\\brotten\\B", "").toLowerCase();
//		}
		// inplace operation for Java Array
		for (int i = 0; i < fruitBasket.length; ++i) {
			String fruit = fruitBasket[i];
			fruit = fruit.replaceAll("\\brotten\\B", "").toLowerCase();
			fruitBasket[i] = fruit;
		}
		
		return fruitBasket;
	}
}
