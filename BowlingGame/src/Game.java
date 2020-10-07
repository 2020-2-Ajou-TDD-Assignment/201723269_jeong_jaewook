
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
		int i=0;
		for (int frame=0; frame<10; frame++) {
			if (rolls[i] + rolls[i+1] == 10) //spare
			{
				score += 10 + rolls[i+2];
				i += 2;
			} else {
				score += rolls[i] + rolls[i+1];
				i+=2;
			}
		}
		return score;
	}

}
