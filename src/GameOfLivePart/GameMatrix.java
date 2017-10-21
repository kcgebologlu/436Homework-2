package GameOfLivePart;
//Korhan Çağın Geboloğlu 
//2012400075
//kcgebologlu@gmail.com
//CMPE436-Assignment 1
/**
 * Two dimensional array structure for representing the Matrix of Game of Life
 * with some features of that matrix
 * @author Korhan Çağın Geboloğlu
 *
 */
public class GameMatrix {
	 int data[][];
	 int height;
	 int length;
	/**
	 * create a two dimensional matrix
	 * with a shell 
	 * @param height the row number of matrix
	 * @param length the column number of matrix
	 */
	public GameMatrix(int height,int length){
		this.height = height+2;
		this.length = length+2;
		this.data = new int [this.height][this.length];
		protectorAdder();
	}
	/**
	 * put 0's to outside of main matrix 
	 * make a shell for main data
	 */
	private void protectorAdder() {
		for (int i = 0; i < height; i++) {
			data[i][0]= 0;
			data[i][length-1]= 0;
		}
		for (int i = 0; i < length; i++) {
			data[0][i]= 0;
			data[height-1][i]= 0;
		}
	}
	/**
	 * Basically add the value into matrix
	 * take the value 
	 * put that value into certain point 
	 * inside of two dimensional matrix structure with a shell
	 * @param x the value for specified matrix position
	 * @param height the row position
	 * @param length the column position
	 */
	public void adder(int x,int height,int length){
		this.data[height][length] = x;
	}
	
	/**
	 * take a certain position 
	 * calculate the sum of 8 neighbors of that 
	 * @param height the row position
	 * @param length the column position
	 * @return sum of the neighbor cells
	 */
	/*
	private int calculator(int height, int length){
		int sum = this.data[height-1][length-1]+this.data[height-1][length]+this.data[height-1][length+1];
		sum += this.data[height+1][length-1]+this.data[height+1][length]+this.data[height+1][length+1];
		sum += this.data[height][length-1]+this.data[height][length+1];
		return sum;
	}*/
	/**
	 * 
	 * @return a new Game matrix 
	 */
	/*
	public GameMatrix turnResulter() {
		GameMatrix holder = new GameMatrix(height-2, length-2);
		//		int turn=1;
		for (int i= 1 ; i<(height-1);i++){
			for  (int j= 1 ; j<(length-1);j++){
				int sum = calculator(i, j);
				if(this.data[i][j]==0){
					if(sum==3){
						holder.adder(1, i-1, j-1);
					}else {
						holder.adder(0, i-1, j-1);
					}
				}else if(this.data[i][j]==1){
					if(sum==2||sum==3){
						holder.adder(1, i-1, j-1);
					}else {
						holder.adder(0, i-1, j-1);
					}
				}
				//				System.out.println(turn);
				//				System.out.println(holder.wholeData());
				//				turn++;
			}

		}
		return holder;
	}*/
/*
	public boolean isSame(GameMatrix second){
		for (int i= 1 ; i<height-1;i++){
			for  (int j= 1 ; j<length-1;j++){
				if(this.data[i][j]!=second.positionValue(i-1, j-1)){
					return false;
				}
			}

		}
		return true;
	}
	public boolean isDeath() {
		if (this.total()==0){
			return true;
		}
		return false;
	}
	public boolean isTotalSame(GameMatrix second) {
		if(this.total()==second.total()){
			return true;
		}
		return false;
	}
	private int total() {
		int sum=0;
		for (int i= 1 ; i<height-1;i++){
			for  (int j= 1 ; j<length-1;j++){
				sum+=this.data[i][j];
			}

		}
		return sum;
	}*/

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height-2;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length-2;
	}
	/**
	 * 
	 * @param height the row position
	 * @param length the column position
	 * @return the value at the certain point
	 */
	public int positionValue(int height,int length) {
		return data[height+1][length+1];
	}
	
	/**
	 * 
	 * @return the printable version of matrix with shell included
	 */
	public String wholeData(){
		String temp = "";
		for (int i= 0 ; i<height;i++){
			for  (int j= 0 ; j<length;j++){
				temp=temp+data[i][j]+" ";
			}
			temp = temp+"\n";
		}
		return temp;
	}
	@Override
	public String toString() {
		String temp = "";
		for (int i= 1 ; i<height-1;i++){
			for  (int j= 1 ; j<length-1;j++){
				temp=temp+data[i][j]+" ";
			}
			temp = temp+"\n";
		}
		return temp;
	}

}
