package alphaComponents;

/*ARRAY CONSTANTS CAN ONLY BE USED IN INITIALIZERS - Look up
 * Pujit Mehrotra
 * Period 6
 * 10/20/15
 * BCD 4
 */
public class BCD //NOTE: Class is not equipped to handle negative numbers unless specified.
{
	/*
	 * =====================================================
	 * INSTANCE VARIABLES
	 * =====================================================
	 */
	private int[] digits;

	
	/*
	 * =====================================================
	 * CONSTRUCTORS
	 * =====================================================
	 */
	BCD(int[] bcdDigits)
	{
		digits = new int[bcdDigits.length];
		for (int index = 0; index < digits.length; index ++)
		{
			digits[index] = bcdDigits[index];
		}
	}

	BCD (int num)
	{
		numToDigitsArray(num);
	}


	/*
	 * ==============================================================
	 * PUBLIC METHODS
	 * =============================================================
	 */
	public int numberOfDigits()
	{
		return digits.length;
	}

	public int nthDigit(int n)
	{
		int nthDigit = 0;
		if (n < digits.length)
		{
			nthDigit = digits[n];
		}
		/*Lines 34-38: Default Value is zero in case 
        parameter n is outside the bounds of digits*/
		return nthDigit;
	}

	public void addADigit(int newDigit)
	{
		int[] newDigitsArray = new int[digits.length + 1];

		for (int counter = 0; counter < digits.length; counter++)
		{
			newDigitsArray[counter] = digits[counter];
		}
		newDigitsArray[digits.length] = newDigit;

		digits = new int[digits.length + 1];
		for (int index = 0; index < digits.length; index ++)
		{
			digits[index] = newDigitsArray[index];
		}
	}

	public String toString()
	{
		String strNumber = "";

		for (int counter0 = digits.length - 1; counter0 >= 0; counter0--)
		{
			strNumber += digits[counter0];
			if (counter0 != 0 && (counter0 % 3) == 0)
			{
				strNumber += ",";
			}
		}

		return strNumber;
	}

	public BCD addBCDs (BCD other)
	{
		//Adds two BCDs together and creates a new BCD:

		int indicator = 0; // Indicates which case is true --> for concision
		int[] sumArray; // Will be passed to the BCD that will be returned.
		if (digits.length > other.numberOfDigits())
		{
			sumArray = new int[other.numberOfDigits()];
			indicator = 1; //Our BCD is bigger than the other BCD.
		}
		else if (digits.length < other.numberOfDigits())
		{
			sumArray = new int[digits.length];
			indicator = -1; //Our BCD is smaller than the other BCD.
		}
		else
		{
			//When the length of the BCDs are equal...
			sumArray = new int[digits.length]; 
		}
		int carryOver = 0; //Contains the 'carry over' value during addition
		int tempSum = 0; //Contains the temporary sum of the addition of two BCDs

		for (int counter0 = 0; counter0 < sumArray.length; counter0 ++)
		{
			tempSum = digits[counter0] + other.nthDigit(counter0) + carryOver;
			sumArray[counter0] = tempSum % 10; //Find the one's digit of tempSum
			carryOver = tempSum / 10; //Remainder is removed
		}
		BCD sumBCD = new BCD(sumArray);

		if (indicator > 0)
		{
			for 
			(int counter1 = sumArray.length; counter1 < digits.length; 
					counter1 ++
					)
			{
				tempSum = digits[counter1] + carryOver;
				sumBCD.addADigit(tempSum % 10);
				carryOver = tempSum / 10;
			}
		}
		else if (indicator < 0)
		{
			for 
			(int counter2 = sumArray.length; counter2 < other.numberOfDigits();
					counter2 ++
					)
			{
				tempSum = other.nthDigit(counter2) + carryOver;
				sumBCD.addADigit(tempSum % 10);
				carryOver = tempSum / 10;
			}
		}
		//No action needs to be taken if indicator is equal to 0

		if (carryOver != 0)
		{
			sumBCD.addADigit(carryOver);
			//carryOver should always be 1 if the s
		}

		return sumBCD;
	}

	//----------------------------------------------------------------------------------------------------------BCD5 Below

	private int diagonalSum (int[][] lattice, int column, int row)//Swiched row and column
	{
		int columnSelection = column;
		int rowSelection = row;
		int diagonalSum = 0; //Will be returned

		while 
			((columnSelection >=0 && columnSelection < lattice.length) && 
					(rowSelection >= 0 && rowSelection < lattice[0].length))
		{
			diagonalSum += lattice[columnSelection][rowSelection];
			columnSelection ++;
			rowSelection --;
		}
		return diagonalSum;
	}

	/*
	 * Adds up all of the diagonals in the lattice
	 */
	private int[] addDiagonals(int[][] lattice)
	{//Provided by Mrs. Gerb
		int width = lattice.length;
		int height = lattice[0].length;
		int diagonals = width+height-1;   
		int[] result = new int[diagonals];   
		int diag=diagonals-1;   //Add the diagonals that end at the bottom
		for (int col=width-1;col>=0;col--)
		{     
			result[diag]=diagonalSum(lattice,col,height-1);
			diag--;
		} 
		//Add the diagonals that end at the left side
		for (int row = height-2; row>=0; row--)
		{     
			result[diag]=diagonalSum(lattice,0,row);
			diag--;
		}
		return result;
	}

	/*
	 * Glues the multiplication lattice operations together
	 */
	public BCD multiplyBCDs(BCD other)
	{
		int digitsLength = digits.length;
		int otherLength = other.numberOfDigits();
		int[][] multiplicationLattice= new int[digitsLength][otherLength];

		for (int columnCounter = 0; columnCounter < digitsLength; columnCounter ++)
		{//Selects the column for multiplication
			for (int rowCounter = 0; rowCounter < otherLength; rowCounter ++)
			{//Selects the row for multiplication
				multiplicationLattice[columnCounter][rowCounter] = 
						digits[columnCounter]* other.nthDigit(rowCounter);
			}
		}
		int remaining = 0;
		int[] diagonalSums = addDiagonals(multiplicationLattice);
		int numberOfDiagonals = digits.length+other.numberOfDigits() - 1;
		int[] emptyArray = new int[0];
		BCD answerBCD = new BCD(emptyArray);

		int sum = 0;
		int ones = 0;

		for (int diagSumCounter = 0; diagSumCounter < numberOfDiagonals; diagSumCounter++)
		{
			sum = diagonalSums[diagSumCounter];
			sum += remaining;
			ones = sum % 10;         
			remaining = sum / 10;
			answerBCD.addADigit(ones);
		}

		while (remaining > 0)
		{
			ones = remaining % 10;  
			remaining /= 10;
			answerBCD.addADigit(ones);
		}

		int numberOfDigits = answerBCD.numberOfDigits();
		if (answerBCD.nthDigit((numberOfDigits - 1)) == 0)
		{
			boolean extraZero = true;
			while (extraZero && (numberOfDigits > 1))
			{
				numberOfDigits --;
				if (answerBCD.nthDigit((numberOfDigits - 1)) != 0)
				{
					extraZero = false;
				}
			}
		}

		int[] resultArray = new int[numberOfDigits];
		for (int counter3 = 0; counter3 <numberOfDigits; counter3 ++)
		{
			resultArray[counter3] = answerBCD.nthDigit(counter3);
		}
		BCD resultBCD = new BCD(resultArray);
		return resultBCD;
	}

	//BCD6 Below
	public static BCD factorial (int num)
	{
		//Adaptation of BCD 1
		int factorialStep = 0;
		BCD BCD_factorialStep = new BCD(factorialStep);
		BCD factorialResult = new BCD(num);

		if (num > 1)
		{
			factorialStep = num - 1;
		}
		else
		{
			factorialResult = new BCD(1);
			return factorialResult;
		}

		while (factorialStep > 1)
		{
			BCD_factorialStep = new BCD(factorialStep);
			factorialResult = factorialResult.multiplyBCDs(BCD_factorialStep);
			factorialStep --;
		}            
		return factorialResult;
	}

	public BCD pow(int num)
	{//The current BCD raised to the power of num
		BCD powResult = this;
		if (num == 0)
		{//Declares all numbers to he power of zero as one
			powResult = new BCD(1);
			return powResult;
		}
		for (int counter0 = 1; counter0 <= num; counter0 ++)
		{
			powResult = powResult.multiplyBCDs(this);
		}
		return powResult;
	}
	
	public int[] getDigits() {
		return digits;
	}
	/*
	 * ========================================================================================
	 * PRIVATE METHODS
	 * ========================================================================================
	 */

	private void numToDigitsArray(int num) {
		int digit = num % 10;
		num /= 10;
		digits = new int[1];
		digits[0] = digit;

		while (num > 0)
		{
			digit = num % 10;
			addADigit(digit);
			num /= 10;
		}
	}
}//Class BCD Ends