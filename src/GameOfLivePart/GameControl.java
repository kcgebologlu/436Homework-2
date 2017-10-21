package GameOfLivePart;
import java.io.File;
//Korhan Çağın Geboloğlu 
//2012400075
//kcgebologlu@gmail.com
//CMPE436-Assignment 1
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * read the arguments 
 * Scan the input file if its necessary
 * Make the the turn and 
 * @author Korhan Çağın Geboloğlu
 *
 */
public class GameControl {
	public static void main(String[] args) throws FileNotFoundException {
		
//		 argument read part
		/*
		 int height = Integer.parseInt( args[0]);
		 int length =  Integer.parseInt( args[1]);
		 int turnNumber = Integer.parseInt( args[2]);
		GameMatrix initial;
		if (args.length==4){
			//read from input.txt
			initial = reader(args[3],height,length);
		}else{
			initial = randomMaker(height, length);
		}*/
		 
		//initialization in code
		int height = 5;
		int length = 5;
		int turnNumber = 5;
		GameMatrix initial = randomMaker(height, length);
//		GameMatrix backup = remaker(initial);
		ArrayList<thead> holder = new ArrayList<thead>();
		BinarySemaphore semaphore = new BinarySemaphore(true);
		Semaphore semaphore2 = new Semaphore(-1*height*length);
		Semaphore semaphore3 = new Semaphore(-1*height*length);
		Semaphore[] semaphores= {semaphore2,semaphore3}; 
		for (int i= 0 ; i<height*length;i++){
				int currentHeight = i/length;
				int currentLength = i%length;
				
				thead R1 = new thead(initial, currentHeight, currentLength,semaphore, semaphores);
				holder.add(R1);
		} 
		for (thead thead : holder) {
			thead.start();
		}
		

	      
	 

	}
	private static GameMatrix randomMaker(int height , int length){
		Random rand = new Random();
		GameMatrix holder = new GameMatrix(height, length);
		for (int i= 0 ; i<height;i++){
			for  (int j= 0 ; j<length;j++){
				holder.adder(rand.nextInt(2), i+1, j+1);
			}
		}
		System.out.println(holder.wholeData());
		return holder;
	}
	private static GameMatrix remaker(GameMatrix matrix) {
		GameMatrix holder = new GameMatrix(matrix.getHeight(), matrix.getLength());
		for (int i= 0 ; i<holder.getHeight();i++){
			for  (int j= 0 ; j<holder.getLength();j++){
				holder.adder(matrix.positionValue(i, j),i,j);
			}
		}
		return holder;
	}
	/**
	 * Read the height and length of matrix 
	 * Create a new matrix 
	 * Fill the matrix with numbers in the file
	 * @param name of file where the matrix number included
	 * @return  matrix 
	 * @throws FileNotFoundException
	 */
	private static GameMatrix reader(String name,int height ,int length) throws FileNotFoundException {
		//1* Prepare file to read
		Scanner sc = new Scanner(new File(name));
		GameMatrix matrix = new GameMatrix(height, length);//hold the info of Matrix 
		for (int i= 0 ; i<height;i++){
			for  (int j= 0 ; j<length;j++){
				int temp = sc.nextInt();
				if (temp==0||temp==1){
					matrix.adder(temp, i+1, j+1);
				}else {
					matrix.adder(0,  i+1, j+1);
				}
			}
		}
		sc.close();
		return matrix;
		
	}
}
