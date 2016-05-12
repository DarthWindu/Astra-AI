
public class Databasia {

	static int points;
	static double returningPoints;

	public static double lessThanEight(int placing, int numberOfPlayers){
		if (placing == 0){
			returningPoints = points*.5;
		} else if (placing == 1){
			returningPoints = points *.3;
		} else if (placing == 2){
			returningPoints = points*.2;
		} else{
			returningPoints = 25;
		}

		if ((int)(+ 50* Math.random())+1 == 50)
			returningPoints = returningPoints + 5;

		return returningPoints;
	}

	public static double betweenEightandSixteen(int placing, int numberOfPlayers){
		if  (placing == 0){
			returningPoints = points*.5;
		} else if (placing == 1){
			returningPoints = points*.4;
		} else if (placing == 2){
			returningPoints = points*.3;
		} else if (placing == 3){
			returningPoints = points*.2;
		} else if (placing == 4 || placing == 5){
			returningPoints = points*.1;
		} else if (placing == 6 || placing == 7){
			returningPoints = points*.075;
		} else if (placing >=8 && placing <13){
			returningPoints = points*.05;
		} else {
			returningPoints = 30;
		}

		return returningPoints;
	}

	public static double betweenSeventeenandTwentyfour(int placing, int numberOfPlayers){
		if (placing == 0){
			returningPoints = points*.7;
		} else if (placing == 1) {
			returningPoints = points*.55;
		} else if (placing == 2) {
			returningPoints = points*.4;
		} else if (placing == 3) {
			returningPoints = points*.35;
		} else if (placing == 4 || placing == 5) {
			returningPoints = points*.25;
		} else if (placing == 6 || placing == 7) {
			returningPoints = points*.2;
		} else if (placing >= 8 && placing <12) {
			returningPoints = points*.125;
		} else if (placing >= 13 && placing <16) {
			returningPoints = points*.05;
		} else if (placing >= 17 && placing < 24) {
			returningPoints = points*.025;
		} else {
			returningPoints = 25;
		}
		return returningPoints;
	}


	private static double betweenTwentyfiveandThirtytwo(int placing, int numberOfPlayers) {
		if (placing == 0){
			returningPoints = points*.75;
		} else if (placing == 1) {
			returningPoints = points*.5;
		} else if (placing == 2) {
			returningPoints = points*.45;
		} else if (placing == 3) {
			returningPoints = points*.35;
		} else if (placing == 4 || placing == 5) {
			returningPoints = points*.2;
		} else if (placing == 6 || placing == 7) {
			returningPoints = points*.15;
		} else if (placing >= 8 && placing <12) {
			returningPoints = points*.1;
		} else if (placing >= 12 && placing <16) {
			returningPoints = points*.05;
		} else {
			returningPoints = 20;
		}
		return returningPoints;
	}


	private static double betweenSixtyfiveandNinetysix(int placing, int numberOfPlayers) {
		if (placing == 0){
			returningPoints = points*1;
		} else if (placing == 1) {
			returningPoints = points*.8;
		} else if (placing == 2) {
			returningPoints = points*.6;
		} else if (placing == 3) {
			returningPoints = points*.5;
		} else if (placing == 4 || placing == 5) {
			returningPoints = points*.35;
		} else if (placing == 6 || placing == 7) {
			returningPoints = points*.25;
		} else if (placing >= 8 && placing <12) {
			returningPoints = points*.2;
		} else if (placing >= 12 && placing <16) {
			returningPoints = points*.1;
		} else if (placing >= 16 && placing < 24) {
			returningPoints = points*.05;
		} else if (placing >= 24 && placing < 32) {
			returningPoints = points*.025;
		} else if (placing >= 32 && placing < 48) {
			returningPoints = points*.015;
		}else {
			returningPoints = 25;
		}

		return returningPoints;
	}

	public static double calculateLargeBrackets(int placing, int numberOfPlayers, String playerName){
		points = numberOfPlayers*50;
		double pointPlacing;
		if (numberOfPlayers <=8)
			pointPlacing = lessThanEight(placing, numberOfPlayers);
		else if (numberOfPlayers >8 && numberOfPlayers <=16 )
			pointPlacing = betweenEightandSixteen(placing, numberOfPlayers);
		else if (numberOfPlayers >16 && numberOfPlayers <=24)
			pointPlacing = betweenSeventeenandTwentyfour(placing, numberOfPlayers);
		else if (numberOfPlayers >24 && numberOfPlayers <=32 )
			pointPlacing = betweenTwentyfiveandThirtytwo(placing, numberOfPlayers);
		else if (numberOfPlayers >32 && numberOfPlayers <=48)
			pointPlacing = betweenThirtythreeandFortyeight(placing, numberOfPlayers);
		else if (numberOfPlayers >48 && numberOfPlayers <=64 )
			pointPlacing = betweenFortynineandSixtyfour(placing, numberOfPlayers);
		else if (numberOfPlayers >64 && numberOfPlayers <=96)
			pointPlacing = betweenSixtyfiveandNinetysix(placing, numberOfPlayers);
		else if (numberOfPlayers >96 && numberOfPlayers <=128 )
			pointPlacing = betweenNinetysevenandOnehundredtwentyeight(placing, numberOfPlayers);
		else if (numberOfPlayers >128 && numberOfPlayers <=192)
			pointPlacing = betweenOnehundredtwentynineandOnehundredninetytwo(placing, numberOfPlayers);
		else if (numberOfPlayers >192 && numberOfPlayers <=256 )
			pointPlacing = betweenOnehundredninetythreeandTwohundredfiftysix(placing, numberOfPlayers);
		else if (numberOfPlayers >256 && numberOfPlayers <=384)
			pointPlacing = betweenTwohundredfiftysevenandThreehundredeightyfour(placing, numberOfPlayers);
		else if (numberOfPlayers >384 && numberOfPlayers <=512 )
			pointPlacing = betweenThreehundredeightyfiveandFivehundredtwelve(placing, numberOfPlayers);
		else
			pointPlacing = 0;

		return pointPlacing;
	}
//Methods to write as necessary.
	private static double betweenThreehundredeightyfiveandFivehundredtwelve(int placing, int numberOfPlayers) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double betweenTwohundredfiftysevenandThreehundredeightyfour(int placing, int numberOfPlayers) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double betweenOnehundredninetythreeandTwohundredfiftysix(int placing, int numberOfPlayers) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double betweenNinetysevenandOnehundredtwentyeight(int placing, int numberOfPlayers) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double betweenOnehundredtwentynineandOnehundredninetytwo(int placing, int numberOfPlayers) {
		// TODO Auto-generated method stub
		return 0;
	}


	private static double betweenFortynineandSixtyfour(int placing, int numberOfPlayers) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double betweenThirtythreeandFortyeight(int placing, int numberOfPlayers) {
		// TODO Auto-generated method stub
		return 0;
	}

	



}

