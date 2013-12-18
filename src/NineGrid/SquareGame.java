package NineGrid;
//import java.util.ArrayList;



public class SquareGame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//code for init test
		/*Integer[][] nine = new Integer [9][9];
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				nine[i][j] = 0;
			}
		}
		nine[0][0] = 1;
		nine[0][1] = 5;
		nine[0][2] = 4;
		nine[0][3] = 6;
		nine[0][4] = 2;
		nine[0][5] = 9;
		nine[0][6] = 7;
		nine[0][8] = 8;
		nine[1][1] = 2;
		nine[1][3] = 3;
		nine[1][6] = 6;
		nine[2][0] = 6;
		nine[2][2] = 3;
		nine[2][8] = 1;
		nine[3][1] = 6;
		nine[3][2] = 5;
		nine[4][0] = 2;
		nine[4][6] = 3;
		nine[5][3] = 9;
		nine[5][5] = 1;
		nine[6][0] = 3;
		nine[6][4] = 5;
		nine[6][8] = 9;
		nine[7][3] = 2;
		nine[8][1] = 4;
		nine[8][7] = 7;
		
		Integer[][] nine = {
				{8,0,0,0,0,0,0,0,0},
				{0,0,3,6,0,0,0,0,0},
				{0,7,0,0,9,0,2,0,0},
				{0,5,0,0,0,7,0,0,0},
				{0,0,0,0,4,5,7,0,0},
				{0,0,0,1,0,0,0,3,0},
				{0,0,1,0,0,0,0,6,8},
				{0,0,8,5,0,0,0,1,0},
				{0,9,0,0,0,0,4,0,0}
		};
		
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				System.out.print(nine[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		NineSquare nineSquare = new NineSquare(nine);
		CalculateNineSquare calculate = new CalculateNineSquare();
		calculate.calculateResult(nineSquare);
		ArrayList<NineSquare> result = calculate.returnResult();
		System.out.println(result.size());
		for(int i=0; i<5; i++){
			for(int j=0; j<9; j++){
				System.out.print("{");
				for(int k=0; k<9; k++){
					System.out.print(result.get(i).getNineSquare()[j][k] + ",");
				}
				System.out.println("}");
			}
			System.out.println();
		}*/
		GUISolver.creatWindow();
	}
	
	public static boolean hasSameNum(Integer [][] nine){
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(nine[i][j] == 0){
					continue;
				}
				for(int k=0; k<9; k++){
					if(k == j){
						continue;
					}
					if(nine[i][k] == 0){
						continue;
					}
					if(nine[i][j] == nine[i][k]){
						return false;
					}
				}
				for(int k=0; k<9; k++){
					if(k == i){
						continue;
					}
					if(nine[k][j] == 0){
						continue;
					}
					if(nine[i][j] == nine[k][j]){
						return false;
					}
				}
				for(int k=(i/3)*3; k<(i/3)*3+3; k++){
					for(int h=(j/3)*3; h<(j/3)*3+3; h++){
						if(k == i && h == j){
							continue;
						}
						if(nine[k][h] == 0){
							continue;
						}
						if(nine[i][j] == nine[k][h]){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
