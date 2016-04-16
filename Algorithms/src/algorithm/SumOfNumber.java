package algorithm;

/**
 * Find sum of all digits in given number (int).
 * @author grze
 *
 */
public class SumOfNumber {
	
	public static int countSumOfNumber (int num) {
		int sum = 0; 
		while (num > 9) {
			int modulo = num%10;
			sum +=  modulo;
			num /= 10;		
		}
		sum += num;
		return sum;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(SumOfNumber.countSumOfNumber(123456));
		
		
	}

}
