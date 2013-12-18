package NineGrid;
import java.util.ArrayList;


public class CalculateNineSquare {
	private NineSquareStack stack = new NineSquareStack();
	private ArrayList<NineSquare> result = new ArrayList<NineSquare>();
	private int time = 0;
	
	public boolean calculateResult(NineSquare nineSquare){
		while(nineSquare != null){
			time++;
			int[] least = nineSquare.getLeastSpace();
			if(least == null){
				for(int k=0; k<9; k++){
					for(int l=0; l<9; l++){
						System.out.print(nineSquare.getNineSquare()[k][l] + " ");
					}
					System.out.println();
				}
				System.out.println();
				System.out.println(nineSquare.checkResult());
				return false;
			}
			int i;
			for(i=0; i<9; i++){
				if(least[0] == 0){
					nineSquare.setX(least[1]);
					nineSquare.setY(i);
				}
				else{
					nineSquare.setX(i);
					nineSquare.setY(least[1]);
				}
				Integer[] temp = nineSquare.getData();
				if(temp != null){
					if(temp.length > 0){
						for(int j=0; j<temp.length; j++){
							nineSquare.setValue(temp[j]);
							/*if(nineSquare.getLeastSpace() == null){
								System.out.println(1);
								System.out.println(nineSquare.checkResult());
							}*/
							if(nineSquare.checkResult()){
								NineSquare newSquare = stack.newNineSquare(nineSquare);
								newSquare.setTime(time);
								//if(SquareGame.hasSameNum(newSquare.getNineSquare())){
									result.add(newSquare);
								//}
								nineSquare = stack.pop();
								//System.out.println(1);
							}
							else if(j<temp.length-1 && temp.length>1){
								NineSquare newSquare = stack.newNineSquare(nineSquare);
								stack.push(newSquare);
							}
						}
					}
					else{
						nineSquare = stack.pop();
						break;
					}
				}
			}
		}
		return true;
	}
	public ArrayList<NineSquare> returnResult(){
		return result;
	}
	public boolean isSameResult(NineSquare newSquare){
		if(result.size() == 0){
			return true;
		}
		for(int i=0; i<result.size(); i++){
			for(int j=0; j<9; j++){
				for(int k=0; k<9; k++){
					if(result.get(i).getNineSquare()[j][k] != newSquare.getNineSquare()[j][k])
						return true;
				}
			}
		}
		return false;
	}
}
