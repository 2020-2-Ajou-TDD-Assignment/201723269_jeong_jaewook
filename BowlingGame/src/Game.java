
public class Game {

	private int score = 0;
	private int rolls[] = new int[21];
	private int currentRoll = 0;
	
	public void roll(int pins) {
		// TODO Auto-generated method stub
		score += pins;
		rolls[currentRoll++] = pins;
	}

	public int score() {
		// TODO Auto-generated method stub
		int score = 0;
		int frameIndex=0;
		for (int frame=0; frame<10; frame++) {
			if (isStrike(frameIndex))
			{
				score += 10 + strikeBonus(frameIndex);
				frameIndex++;
			}
			else if (isSpare(frameIndex))
			{
				score += 10 + spareBonus(frameIndex);
				frameIndex += 2;
			} else {
				score += sumOfBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}

	private int sumOfBallsInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex+1];
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

	private boolean isSpare(int frameIndex) {
		return sumOfBallsInFrame(frameIndex) == 10;
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex+1]+spareBonus(frameIndex);
	}
}
