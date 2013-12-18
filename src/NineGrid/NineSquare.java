package NineGrid;
import java.util.ArrayList;


public class NineSquare {
	private Integer[][] nineSquare = new Integer[9][9];
	private Boolean[][] hasNumber = new Boolean[9][9];
	private int x = 0;
	private int y = 0;
	private int time = 0;
	
	public NineSquare(Integer[][] nineSquare){
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				this.nineSquare[i][j] = nineSquare[i][j];
				if(nineSquare[i][j] != 0){
					this.hasNumber[i][j] = true;
				}
				else{
					this.hasNumber[i][j] = false;
				}
			}
		}
	}
	//get the useful numbers can be write on spot (x,y)
	public Integer[] getData(){
		if(hasNumber[x][y]){
			return null;
		}
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		//search useful number in a row
		for(int i=1; i<10; i++){
			boolean hasNum = false;
			for(int j=0; j<9; j++){
				if(nineSquare[x][j] == i){
					hasNum = true;
					break;
				}
			}
			if(!hasNum){
				tempList.add(i);
			}
		}
		//search number both not in row and column
		for(int i=0; i<tempList.size(); i++){
			for(int j=0; j<9; j++){
				if(nineSquare[j][y] == tempList.get(i)){
					tempList.remove(i);
					i--;
					break;
				}
			}
		}
		//search number both not in row and column and small square
		for(int i=0; i<tempList.size(); i++){
			int start_x = (x/3)*3;
			int start_y = (y/3)*3;
			for(int j=start_x; j<start_x+3; j++){
				int k;
				for(k=start_y; k<start_y+3; k++){
					if(nineSquare[j][k] == tempList.get(i)){
						tempList.remove(i);
						i--;
						break;
					}
				}
				if(k < start_y+3)
					break;
			}
		}
		Integer[] usefulNum = new Integer[tempList.size()];
		for(int i=0; i<tempList.size(); i++){
			usefulNum[i] = tempList.get(i);
		}
		return usefulNum;
	}
	//find the spot has the least spaces
	public int[] getLeastSpace(){
		int xLeast = 10;//space number in column
		int yLeast = 10;//space number in row
		int x_spot = 10;//column has the least space
		int y_spot = 10;//row has the least space
		//calculate space number in each column
		for(int i=0; i<9; i++){
			int temp = 0;
			for(int j=0; j<9; j++){
				if(nineSquare[i][j] == 0)
					temp++;
			}
			if(temp>0 && temp<xLeast){
				xLeast = temp;
				x_spot = i;
			}
		}
		if(xLeast == 1){
			int[] value = new int[2];
			value[0] = 0;//stands for column
			value[1] = x_spot;//stands for which column
			return value;
		}
		else{
			//calculate space number in each row
			for(int i=0; i<9; i++){
				int temp = 0;
				for(int j=0; j<9; j++){
					if(nineSquare[j][i] == 0)
						temp++;
				}
				if(temp>0 && temp<yLeast){
					yLeast = temp;
					y_spot = i;
				}
			}
		}
		//compare column and row
		if(xLeast < yLeast){
			int[] value = new int[2];
			value[0] = 0;
			value[1] = x_spot;
			return value;
		}
		else if(xLeast >= yLeast && xLeast < 10 && yLeast < 10){
			int[] value = new int[2];
			value[0] = 1;
			value[1] = y_spot;
			return value;
		}
		else{
			return null;
		}
	}
	//check if we have a right result
	public boolean checkResult(){
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(nineSquare[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setTime(int time){
		this.time = time;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getTime(){
		return time;
	}
	public Integer[][] getNineSquare(){
		return this.nineSquare;
	}
	public Boolean[][] getHasNumber(){
		return this.hasNumber;
	}
	public void setValue(int value){
		nineSquare[x][y] = value;
		hasNumber[x][y] = true;
	}
	public int getValue(){
		return nineSquare[x][y];
	}
}
