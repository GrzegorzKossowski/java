package algorithm;

/**
 * Find sum of all digits in given number (int).
 * @author grze<br>
 * <a href="http://www.codefights.com">source of challenge</a> *
 */
public class SumOfNumber {
	
	public static int countSumOfNumber (int num) {
		
		int sum = 0; //sum of integer digits 
		while (num > 9) {
			int modulo = num%10;
			sum +=  modulo;
			num /= 10;		
		}
		sum += num;	//if num <10
		return sum;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(SumOfNumber.countSumOfNumber(123456));
		
		
	}

}
