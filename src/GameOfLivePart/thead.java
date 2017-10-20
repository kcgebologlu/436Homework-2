package GameOfLivePart;

public class thead implements Runnable {
	private Thread t;
	int threadNo;
	GameMatrix matrix;
	int height;
	int length;
	public thead(GameMatrix matrix,int height,int length) {
		this.matrix = matrix;
		this.height = height+1;
		this.length = length+1;
		threadNo = height*matrix.getLength()+length+1;
		System.out.println("Creating " +  threadNo );

	}
	public void run() {
		System.out.println("Running " +  threadNo );
		try {
			for(int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadNo + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
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