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



	public ImpBCD subtract(ImpBCD bcd1, ImpBCD bcd2) {
		int[] answer;
		ImpBCD num1 = bcd1.clone(), num2 = bcd2.clone();
		int[] num1Digits = num1.getDigits(), num2Digits = num2.getDigits();
		boolean isSameSignAsBCD2;

		if (num1.numberOfDigits() >= num2.numberOfDigits())
		{//Num1 is greater than num2
			answer = new int[num2.numberOfDigits()];
			for (int digit = num2.numberOfDigits() - 1; digit >= 0; digit --) {
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

	}
}
