package alphaComponents;

import javafx.stage.Stage;

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
				1	
		};

		int[] num2 = {
				1,0
		};

		num1 = padNum2(num2, num1);
		for(int num : num1) {
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

	public static ImpBCD subtraction2(int[] num1Digits, int[] num2Digits) {
		int[] answer;
		num1Digits = padNum2(num2Digits, num1Digits);

		answer = new int[num2Digits.length];
		//First digit of num2 MUST be less than first digit of num1

		for (int digit = answer.length - 1; digit >= 0; digit --) {
			if (num2Digits[digit] >= num1Digits[digit]) {
				//If num 1 digit is greater than num 2 digit
				answer[digit] = num2Digits[digit] - num1Digits[digit];

			}
			else {
				answer[digit] = (num2Digits[digit] + 10) - num1Digits[digit];
				int digitToDecrease = digit - 1;

				if (num1Digits[digitToDecrease] == 0) {
					try{
						while(num1Digits[digitToDecrease] == 0) {
							digitToDecrease --;
						}//Dips one digit below needed digit if completed w/o exception

						num1Digits[digitToDecrease + 1] --;

						for (int counter = digitToDecrease + 2; counter < digit; counter ++ ) {
							num2Digits[counter] = 9;
						}

					}
					catch(ArrayIndexOutOfBoundsException e) {
						//Incomplete?
						answer[digit] = num2Digits[digit] - num1Digits[digit];
					}
				}
				else {
					num1Digits[digitToDecrease] --;
				}
			}
		}
		return new ImpBCD(answer, 0/*placeholder value*/, false);
	}
	
	public static void cloneTest(ImpBCD bcd1, ImpBCD bcd2) {
		System.out.println("Imp 1: " + bcd1);
		System.out.println("Imp 2: " + bcd2);
		System.out.println("Clone 1: " + bcd1.clone());
		System.out.println("Clone 2: " + bcd2.clone());
	}
	
	public static void launchLoginGUI() {
		LoginGUI.launch(LoginGUI.class);
	}

	public static void main(String[] args) {
		//runPadNum2Test();
		/*int maxNumToSubtract = 30;
		for (int counter = 1; counter <= 21; counter ++) {
			System.out.println("================== Unit Test " + counter + " ===================");
			subtractionTester0(counter, maxNumToSubtract);
			System.out.println("~~~~~~~~~~~~~~~~~~ End Unit Test " + counter + " ~~~~~~~~~~~~~~~~~~~~~~~");
		}*/

		/*int[] num1 = {
				1	
		};

		int[] num2 = {
				1,0
		};*/
		
		/*System.out.println(subtraction2(num1, num2));*/
		
		/*cloneTest(new ImpBCD(1), new ImpBCD(num2));
		System.out.println(num2[0]);*/
		
		launchLoginGUI();
	}

}
