package alphaComponents;

public class Tester {
	
	public static int[] padNum2(int[] num1Digits, int[] num2Digits) {
		int[] tempArray;
		while(num2Digits.length < num1Digits.length) {
			tempArray = new int[num2Digits.length + 1];
			
			for (int counter = 0; counter < num2Digits.length; counter ++) {
				tempArray[counter + 1] = num2Digits[counter];
				//First element is defaulted to 0; all other values are moved one digit to the right
			}
			
			//Copy tempArray into num2Digits
			num2Digits = new int[tempArray.length];
			for (int counter = 0; counter < tempArray.length; counter ++) {
				num2Digits[counter] = tempArray[counter];
			}
		}
		return num2Digits;
	}
	
	public static void runPadNum2Test() {
		int[] num1 = {
				5,0,0	
			};
			
			int[] num2 = {
					1,1,1,9
			};
			
			num2 = padNum2(num1, num2);
			for(int num : num2) {
				System.out.print(num);
			}
	}
	
	public static void subtractionTester0(int baseNum, int maxNumToSubtract) {
		ImpBCD bcd1 = new ImpBCD(baseNum, 0, false);
		for (int counter = 1; counter<=maxNumToSubtract + 1; counter ++) {
			System.out.println("TEST CASE " + counter + ":");
			ImpBCD bcd2 = new ImpBCD(counter - 1, 0, false);
			ImpBCD answer = bcd1.subtract(bcd1, bcd2);
			System.out.println("Base Number: " + baseNum);
			System.out.println("Number to subtract: " + (counter - 1));
			System.out.println("Answer: " + answer);
			System.out.println("isNeg: " + answer.isNegative());
			System.out.println("-----------------------------------------\n");
		}
	}
	
	public static void main(String[] args) {
		//runPadNum2Test();
		int maxNumToSubtract = 30;
		for (int counter = 1; counter <= 21; counter ++) {
			System.out.println("================== Unit Test " + counter + " ===================");
			subtractionTester0(counter, maxNumToSubtract);
			System.out.println("~~~~~~~~~~~~~~~~~~ End Unit Test " + counter + " ~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}

}
