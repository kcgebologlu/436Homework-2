package GameOfLivePart;

import java.io.PrintWriter;

public class thead implements Runnable {
	private Thread t;
	int threadNo;
	GameMatrix matrix;
	int height;
	int length;
	BinarySemaphore sem;
	Semaphore[] sem2;
	public thead(GameMatrix matrix,int height,int length,BinarySemaphore sem,Semaphore[] sem2) {
		this.matrix = matrix;
		this.height = height+1;
		this.length = length+1;
		this.sem = sem;
		this.sem2 = sem2;
		threadNo = height*matrix.getLength()+length+1;
		System.out.println("Creating " +  threadNo );

	}
	public void run() {
		
		try {
			sem.P();
			System.out.println("Running " +  threadNo );
			int sum = matrix.data[height-1][length-1]+matrix.data[height-1][length]+matrix.data[height-1][length+1];
			sum += matrix.data[height+1][length-1]+matrix.data[height+1][length]+matrix.data[height+1][length+1];
			sum += matrix.data[height][length-1]+matrix.data[height][length+1];
			if(matrix.data[height][length]==0){
				if(sum==3){
					sum = 1; 
				}else {
					sum = 0; 
				}
			}else {
				if(sum==2||sum==3){
					sum = 1; 
				}else {
					sum = 0; 
				}
			}
			sem.V();
			sem2[0].P();
			matrix.data[height][length] = sum;
			System.out.println(sum);
			sem2[1].P();
			sem2[0].V();
			System.out.println(matrix.wholeData());
			sem2[1].V();
			
		}catch (InterruptedException e) {
			System.out.println("Thread " +  threadNo + " interrupted.");
		}
		System.out.println("Thread " +  threadNo + " exiting.");
	}

	public void start () {
		System.out.println("Starting " +  threadNo );
		if (t == null) {
			t = new Thread (this, ""+threadNo);
			t.start ();
		}
	}
} 