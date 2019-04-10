package net.ukr.andy777;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 Lesson10
 3. Решить задачу подсчета повторяющихся элементов в массиве с помощью HashMap.
 */

public class Main {
	public static void main(String[] args) {
		Object[] array = generateArray(1000000);

		Map<Object, Integer> numbers = count(array);
		Set<Object> keys = numbers.keySet();
		for (Object key : keys)
			System.out.println(key + " = " + numbers.get(key) + "\t" + (numbers.get(key) * 100.0) / array.length + "%");
	}

	public static Object[] generateArray(int n) {
		Object[] array = new Object[n];
		Random rn = new Random();
		for (int i = 0; i < array.length / 4; i++)
			array[i] = rn.nextInt(10);
		for (int i = array.length / 4; i < array.length * 2 / 4; i++)
			array[i] = rn.nextInt(10) * 1.0;
		for (int i = array.length * 2 / 4; i < array.length * 3 / 4; i++)
			array[i] = (int) (rn.nextFloat() * 1000) / 10;
		for (int i = array.length * 3 / 4; i < array.length; i++)
			array[i] = rn.nextBoolean();
		array[0] = "start";
		array[1] = "first";
		array[array.length - 2] = "end";
		array[array.length - 1] = "end";
		return array;
	}

	public static Map<Object, Integer> count(Object[] array) {
		Map<Object, Integer> number = new HashMap<Object, Integer>();
		for (Object i : array) {
			Integer element = number.get(i);
			if (element != null)
				number.put(i, element + 1);
			else
				number.put(i, 1);
		}
		return number;
	}
}
