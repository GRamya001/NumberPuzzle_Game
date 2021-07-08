import java.awt.*;
import java.util.*;
class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here	
		int idx = 0;
		for(int i=0;i<=15;i++) {
			if(buttons[i]==buttonClicked) {
				idx = i;
				break;
			}
		}

		if((idx+1==emptyCellId && (idx+1)%4!=0) || (idx-1) ==emptyCellId && (idx%4!=0)|| idx+4==emptyCellId || idx-4==emptyCellId) {
			swapButton(buttons[emptyCellId], buttonClicked);
			return idx;
		}
		else {
			return emptyCellId;
		}

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while(numbers.size()!=15) {
			int a = getRandomNumber();
			if(!numbers.contains(a%16)&&(a%16)!=0) {
				numbers.add(a%16);
			}
		}
		for(int i=0;i<15;i++) {
			arr[i]=numbers.get(i);
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] numbers = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]!=i+1) {
				winner=false;
				break;
			}
		}

		return winner;
	}
}