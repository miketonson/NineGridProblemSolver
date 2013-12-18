package NineGrid;
import java.util.ArrayList;


public class NineSquareStack {
	private ArrayList<NineSquare> squareStack = new ArrayList<NineSquare>();
	
	public void push(NineSquare newSquare){
		squareStack.add(newSquare);
	}
	public NineSquare pop(){
		if(squareStack.size() > 0){
			NineSquare newSquare = newNineSquare(squareStack.remove(squareStack.size()-1));
			return newSquare;
		}
		else{
			return null;
		}
	}
	public NineSquare newNineSquare(NineSquare nineSquare){
		Integer[][] newNine = new Integer[9][9];
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				newNine[i][j] = nineSquare.getNineSquare()[i][j];
			}
		}
		NineSquare newSquare = new NineSquare(newNine);
		newSquare.setX(nineSquare.getX());
		newSquare.setY(nineSquare.getY());
		newSquare.setTime(nineSquare.getTime());
		return newSquare;
	}
}
