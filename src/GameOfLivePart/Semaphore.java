package GameOfLivePart;

public class Semaphore {

    protected int permit = 0;


    public Semaphore() {
        permit = 0;
    }

    public Semaphore(int permit) {
        this.permit = permit;
    }

    public synchronized void P() {
        permit++;
        if (permit < 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
    }

    public synchronized void V() {
            notifyAll();
    }

}