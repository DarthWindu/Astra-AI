package alphaComponents;

public class ImpBCD extends BCD{

	/**
	 * Read Documentation for more info
	 * decPlace is the number of digits after decimal place
	 * 0 means no decimal (at digits.length)
	 * 1 means 1 digit after tenths place
	 */
	private int decPlace;
	private boolean isNegative;
	//@Inherited protected int[] digits


	ImpBCD(int[] bcdDigits) {
		super(bcdDigits);
		// TODO Auto-generated constructor stub
	}

	ImpBCD(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}

	ImpBCD(int num, int numOfDigitsAfterDecPt, boolean negative) {
		super(num);
		decPlace = numOfDigitsAfterDecPt;
		isNegative = negative;
	}

	ImpBCD(int[] bcdDigits, int numOfDigitsAfterDecPt, boolean negative) {
		super(bcdDigits);
		decPlace = numOfDigitsAfterDecPt;
		isNegative = negative;
	}


	public ImpBCD clone() {
		return new ImpBCD(this.getDigits(), decPlace, isNegative);
	}
	
	public boolean isNegative() {
		return isNegative;
	}



	public ImpBCD subtract(ImpBCD bcd1, ImpBCD bcd2) {
		int[] answer;
		ImpBCD num1 = bcd1.clone(), num2 = bcd2.clone();
		int[] num1Digits = num1.getDigits(), num2Digits = num2.getDigits();
		boolean isSameSignAsBCD2 = true;

		if (num1.numberOfDigits() >= num2.numberOfDigits())
		{//Num1 is greater than num2
			//Pad num2Array
			num2Digits = padNum2(num1Digits, num2Digits);
			answer = new int[num2Digits.length];

			for (int digit = answer.length - 1; digit >= 0; digit --) {
				if (num1Digits[digit] >= num2Digits[digit]) {
					//If num 1 digit is greater than num 2 digit
					answer[digit] = num1Digits[digit] - num2Digits[digit];

				}
				else {
					if (digit > 0) {
						answer[digit] = (num1Digits[digit] + 10) - num2Digits[digit];
						int digitToDecrease = digit - 1;

						if (num1Digits[digitToDecrease] == 0) {
							try{
								while(num1Digits[digitToDecrease] == 0) {
									digitToDecrease --;
								}//Dips one digit below needed digit if completed w/o exception

								num1Digits[digitToDecrease + 1] --;

								for (int counter = digitToDecrease + 2; counter < digit; counter ++ ) {
									num1Digits[counter] = 9;
								}

							}
							catch(ArrayIndexOutOfBoundsException e) {
								//Incomplete?
								isSameSignAsBCD2 = false;
								answer[digit] = num2Digits[digit] - num1Digits[digit];
							}
						}
						else {
							num1Digits[digitToDecrease] --;
						}

					}
					else {
						isSameSignAsBCD2 = false;
						answer[digit] = num2Digits[digit] - num1Digits[digit];
					}//Incomplete
				}
			}

		}
		else {
			isSameSignAsBCD2 = false;
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
							isSameSignAsBCD2 = false;
							answer[digit] = num2Digits[digit] - num1Digits[digit];
						}
					}
					else {
						num1Digits[digitToDecrease] --;
					}
				}
			}
		}
		
		if (isSameSignAsBCD2) {
			return new ImpBCD(answer, 0/*placeholder value*/, bcd2.isNegative());
		}
		else {
			return new ImpBCD(answer, 0/*placeholder value*/, !bcd2.isNegative());
		}

	}

	/*
	 * ================================================
	 * PRIVATE METHODS
	 * ================================================
	 */
	/**
	 * Pads num2Digits with 0's at the beginning until num2Digits
	 * is as large as num1Digits.
	 * @param num1Digits
	 * @param num2Digits
	 * @return num2Digits: padded num2Digits
	 */
	private int[] padNum2(int[] num1Digits, int[] num2Digits) {
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
}
